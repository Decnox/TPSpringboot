package fr.paris8univ.iut.csid.csidwebrepositorybase;

public class Statistiques {

    private String repo_name;
    private String entry_type;
    private String datetime;
    private Integer value;

    public Statistiques(String repo_name, String entry_type, String datetime, Integer value){
        this.repo_name = repo_name;
        this.entry_type = entry_type;
        this.datetime = datetime;
        this.value = value;
    }


    public String getRepo_name() {
        return repo_name;
    }

    public void setRepo_name(String repo_name) {
        this.repo_name = repo_name;
    }

    public String getEntry_type() {
        return entry_type;
    }

    public void setEntry_type(String entry_type) {
        this.entry_type = entry_type;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
