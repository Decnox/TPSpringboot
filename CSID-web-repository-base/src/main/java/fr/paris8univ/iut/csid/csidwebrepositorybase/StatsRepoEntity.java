package fr.paris8univ.iut.csid.csidwebrepositorybase;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "statistiques")
public class StatsRepoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "repo_name")
    private String repo_name;

    @Column(name = "entry_type")
    private String entry_type;

    @Column(name = "datetime")
    private String datetime;

    @Column(name = "value")
    private Integer value;

    public StatsRepoEntity() {
    }

    public StatsRepoEntity(Integer id, String repo_name, String entry_type, String datetime, Integer value){
        this.id = id;
        this.repo_name = repo_name;
        this.entry_type = entry_type;
        this.datetime = datetime;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public String getRepo_name() {
        return repo_name;
    }

    public String getEntry_type() {
        return entry_type;
    }

    public String getDatetime() {
        return datetime;
    }

    public Integer getValue() {
        return value;
    }
}
