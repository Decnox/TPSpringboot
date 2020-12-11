package fr.paris8univ.iut.csid.csidwebrepositorybase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface statsDao extends JpaRepository<StatsRepoEntity,String> {
    @Query(value = "select * from statistiques as stats where stats.repo_name= ?1 and stats.entry_type= ?2 order by datetime desc ",nativeQuery=true)
    List<StatsRepoEntity> findAllStatByNameAndTypeOrdered(String name_repo, String entry_type);
}
