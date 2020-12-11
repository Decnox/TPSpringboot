package fr.paris8univ.iut.csid.csidwebrepositorybase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsService {

    private StatsRepository statsRepo;

    @Autowired
    public StatsService(StatsRepository statsRepo){
        this.statsRepo = statsRepo;
    }

    public List<Statistiques> getStatsRepo(String name_repo, String entry_type){
        return statsRepo.getStatsByNameAndType(name_repo, entry_type);
    }
}
