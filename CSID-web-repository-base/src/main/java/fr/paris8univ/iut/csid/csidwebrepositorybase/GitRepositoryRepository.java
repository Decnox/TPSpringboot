package fr.paris8univ.iut.csid.csidwebrepositorybase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.net.URISyntaxException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class GitRepositoryRepository {
    private final GitRepositoryDao gitRepositoryDao;
    private final GithubRepositoryDAO githubRepositoyDAO;
    private final statsDao statistiquesDao;

    //private final List<GitRepository> repositories = List.of(new GitRepository("test", "jule",5,5),
    //new GitRepository("machin", "jean",5,5));

    @Autowired
    public GitRepositoryRepository(GitRepositoryDao gitRepositoryDao, GithubRepositoryDAO githubRepositoryDAO, statsDao statistiquesDao) {

        this.gitRepositoryDao=gitRepositoryDao;
        this.githubRepositoyDAO=githubRepositoryDAO;
        this.statistiquesDao = statistiquesDao;
    }

    public List<GitRepository> getRepositories(){
        List<GitRepositoryEntity> repositoryEntities = gitRepositoryDao.findAll();
        return repositoryEntities.stream()
                .map(x -> new GitRepository(x.getName(),x.getOwner(),x.getIssues(),x.getForks(),x.getTime()))
                .collect(Collectors.toList());
    }

    public Optional<GitRepository> findOneRepository(String name) throws URISyntaxException {
        GitRepositoryEntity myGitRepoEntity = gitRepositoryDao.findById(name).get();
        GitRepository newGitRepoository = new GitRepository(myGitRepoEntity.getName(), myGitRepoEntity.getOwner(),myGitRepoEntity.getIssues(),myGitRepoEntity.getForks(), myGitRepoEntity.getTime());


        if ((Instant.now().getEpochSecond()-newGitRepoository.getTime())>300) {
            GitRepositoryDTO myGitRepoDTO;
            myGitRepoDTO = githubRepositoyDAO.GetGitRepositoryDTO(newGitRepoository.getName(), newGitRepoository.getOwner());
            newGitRepoository.setIssues(myGitRepoDTO.getOpen_issues());
            newGitRepoository.setForks(myGitRepoDTO.getForks());
            newGitRepoository.setTime((Instant.now().getEpochSecond()));
            String dateUsingSecond = LocalDateTime.ofEpochSecond(newGitRepoository.getTime(),0, ZoneOffset.UTC).toString();
            statistiquesDao.save(new StatsRepoEntity(0, newGitRepoository.getName(),"issues", dateUsingSecond, newGitRepoository.getIssues()));
            statistiquesDao.save(new StatsRepoEntity(0, newGitRepoository.getName(),"forks", dateUsingSecond, newGitRepoository.getForks()));
            patchRepository(newGitRepoository.getName(), newGitRepoository);

        }
        return Optional.of(newGitRepoository);
    }

    public void creatRepository(GitRepository gitRepository){
        gitRepositoryDao.save(new GitRepositoryEntity(gitRepository.getName(),gitRepository.getOwner(),gitRepository.getIssues(),gitRepository.getForks(),gitRepository.getTime()));
    }

    public void putRepository(String name,GitRepository gitRepository) {
        Optional<GitRepositoryEntity> gitRepositories =  gitRepositoryDao.findById(name);
        if (gitRepositories.isEmpty()){
            creatRepository(gitRepository);
        }
        else{
            GitRepositoryEntity setRepository = gitRepositories.get();
            setRepository.setOwner(gitRepository.getOwner());
            setRepository.setIssues(gitRepository.getIssues());
            setRepository.setForks(gitRepository.getForks());
            setRepository.setTime(gitRepository.getTime());
            gitRepositoryDao.save(setRepository);
        }
    }

    public void patchRepository(String name, GitRepository gitRepository) {
        Optional<GitRepositoryEntity> repository = gitRepositoryDao.findById(name);
        GitRepositoryEntity repositoryModified = repository.get();

        if(gitRepository.getOwner() != null)
            repositoryModified.setOwner(gitRepository.getOwner());
        if(gitRepository.getIssues() != 0 )
            repositoryModified.setIssues(gitRepository.getIssues());
        if(gitRepository.getForks() != 0)
            repositoryModified.setForks(gitRepository.getForks());

        gitRepositoryDao.save(repositoryModified);
    }

    public void deleteRepository(String name) {
        gitRepositoryDao.deleteById(name);
    }

}

