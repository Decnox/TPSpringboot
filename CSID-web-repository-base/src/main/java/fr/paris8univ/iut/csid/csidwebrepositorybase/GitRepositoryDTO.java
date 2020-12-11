package fr.paris8univ.iut.csid.csidwebrepositorybase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitRepositoryDTO {
	
	private String name;
	private String login;
	private int open_issues;
	private int forks;
	
	public GitRepositoryDTO(String name, String login, int open_issues, int forks){
		this.name=name;
		this.login=login;
		this.open_issues=open_issues;
		this.forks=forks;
	}
	
	public String getName() {

		return this.name;
	}
	
	public String getLogin() {

		return this.login;
	}
	
	public void setName(String name) {

		this.name=name;
	}
	
	public void setLogin(String login) {

		this.login=login;
	}

	public int getOpen_issues() {

		return this.open_issues;
	}

	public void setOpen_issues(int issues){

		this.open_issues=issues;
	}

	public int getForks() {

		return this.forks;
	}

	public void setForks(int forks){

		this.forks=forks;
	}

}
