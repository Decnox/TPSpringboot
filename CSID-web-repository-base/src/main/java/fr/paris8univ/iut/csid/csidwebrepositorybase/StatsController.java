package fr.paris8univ.iut.csid.csidwebrepositorybase;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/repositories")
public class StatsController {


    private final StatsService serviceStatistiques;

    @Autowired
    public StatsController(StatsService serviceStatistiques) {
        this.serviceStatistiques = serviceStatistiques;
    }


    @GetMapping("/{name_repo}/stats")
    public List<Statistiques> GetResponseStats(@PathVariable String name_repo, @RequestParam String entry_type){
        return serviceStatistiques.getStatsRepo(name_repo, entry_type);
    }

}
