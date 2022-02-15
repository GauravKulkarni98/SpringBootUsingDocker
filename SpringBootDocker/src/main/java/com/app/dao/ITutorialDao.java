package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Tutorial;

public interface ITutorialDao extends JpaRepository<Tutorial, Integer>{
//get all tutorials under specified topic in a sorted as per visits manner
	//custom query method
	@Query(value = "select t.tutorialName from Tutorial t where t.topic.id=:id order by t.visits desc")
	List<String> getTutorialsByTopicId(@Param("id") int  topicId);

//get tutorial details : finder method
//	Tutorial getTutorialDetails(String tutName);
	Optional<Tutorial> findByTutorialName(String tutName);

	// update visits
	//String updateVisits(String tutName);

	// add new tutorial : Inherited API save from CruRepo.
//	String addNewTutorial(Tutorial tutorial,int topicId);
}
