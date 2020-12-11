package fr.paris8univ.iut.csid.csidwebrepositorybase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class GithubRepositoryDAO {
    private final RestTemplate MyTemplate;

    @Autowired
    public GithubRepositoryDAO(RestTemplateBuilder myTemplateBuilder) {
        MyTemplate = myTemplateBuilder.build();
    }

    public GitRepositoryDTO GetGitRepositoryDTO(String nameGitRepository ,String ownerGitRepository) throws URISyntaxException {
       return MyTemplate.getForEntity(new URI("https://api.github.com/repos/"+ownerGitRepository+"/"+nameGitRepository),GitRepositoryDTO.class).getBody();
    }
}
