package com.app.service;

import java.util.List;

import com.app.pojos.Tutorial;

public interface ITutorialService {
	List<String> getTutorialsByTopic(int topicId);

	Tutorial getUpdatedTutDetails(String tutName);

	String addNewTutorial(Tutorial transientTutorial, Integer topicId);
}
