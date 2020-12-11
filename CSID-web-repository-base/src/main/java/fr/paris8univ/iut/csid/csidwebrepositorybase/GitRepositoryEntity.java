package fr.paris8univ.iut.csid.csidwebrepositorybase;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "repository")
public class GitRepositoryEntity {
	@Id
	@Column(name = "name", unique = true)
	private String name;
	
	@Column(name = "owner")
	private String owner;
	
	@Column(name = "issues")
	private int issues;
	
	@Column(name = "forks")
	private int forks;

	@Column(name = "time")
	private long time;
	
	public GitRepositoryEntity() {}
	
	public GitRepositoryEntity(String name,String owner, int issues,int forks, long time) {
		this.name=name;
		this.owner=owner;
		this.issues=issues;
		this.forks = forks;
		this.time = time;
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

	public void setTime(long time){this.time=time; }

	public long getTime() { return this.time;}
}
