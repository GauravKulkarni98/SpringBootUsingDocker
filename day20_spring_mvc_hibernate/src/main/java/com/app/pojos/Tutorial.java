package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tutorials")
public class Tutorial extends BaseEntity
{
	//id | name        | author | publish_date | visits | contents                                  | topic_id
	@Column(name="name")
	private String tutorialName="some tut";
	private String author;
	@Column(name="publish_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate publishDate;
	private int visits;
	private String contents;
	//uni dir Many to one association : Tutorail * -----> 1 Topic
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="topic_id",nullable = false)
	private Topic topic;
	public Tutorial() {
		// TODO Auto-generated constructor stub
	}
	public Tutorial(String tutorialName, String author, LocalDate publishDate, String contents) {
		super();
		this.tutorialName = tutorialName;
		this.author = author;
		this.publishDate = publishDate;
		this.visits = visits;
		this.contents = contents;
	}
	public String getTutorialName() {
		return tutorialName;
	}
	public void setTutorialName(String tutorialName) {
		this.tutorialName = tutorialName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	public int getVisits() {
		return visits;
	}
	public void setVisits(int visits) {
		this.visits = visits;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	@Override
	public String toString() {
		return "Tutorial ID "+getId()+" [tutorialName=" + tutorialName + ", author=" + author + ", publishDate=" + publishDate
				+ ", visits=" + visits + ", contents=" + contents + "]";
	}
	
	
	
}
