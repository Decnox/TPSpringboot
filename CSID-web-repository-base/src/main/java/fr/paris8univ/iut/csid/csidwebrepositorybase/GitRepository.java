package fr.paris8univ.iut.csid.csidwebrepositorybase;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class GitRepository {
	private String name;
	private String owner;
	private int issues;
	private int forks;
	private long time;
	
	public GitRepository() {}
	
	public GitRepository(String name,String owner, int issues,int forks, long time) {
		this.name=name;
		this.owner=owner;
		this.issues=issues;
		this.forks =forks;
		this.time=time;
	}
	
	public int getIssues() {
		return issues;
	}

	public void setIssues(int issues) {
		this.issues = issues;
	}

	public int getForks() {
		return forks;
	}

	public void setForks(int forks) {
		this.forks = forks;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	public void setOwner(String owner) {
		this.owner=owner;
	}

	public long getTime() {
		return this.time;
	}

	public void setTime(long time) {
		this.time=time;
	}
}
