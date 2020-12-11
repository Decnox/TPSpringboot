package fr.paris8univ.iut.csid.csidwebrepositorybase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StatsRepository {
    private final statsDao statistiquesDao;


    public StatsRepository(statsDao statistiquesDao) {
        this.statistiquesDao = statistiquesDao;
    }


    public statsDao getStatsDao(){
        return statistiquesDao;
    }

    public List<Statistiques> getStatsByNameAndType(String repo_name, String entry_type){
        List<StatsRepoEntity> statistiques = statistiquesDao.findAllStatByNameAndTypeOrdered(repo_name, entry_type);
        return statistiques.stream()
                .map(x -> new Statistiques(x.getRepo_name(), x.getEntry_type(), x.getDatetime(), x.getValue())).collect(Collectors.toList());
    }
}
