package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.ITopicService;
import com.app.service.ITutorialService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	// dependency
	@Autowired
	private ITopicService topicService;
	// dependency
	@Autowired
	private ITutorialService tutorialService;

	public CustomerController() {
		System.out.println("in ctor of " + getClass());
	}

	// add request handling method : to get all topics
	@GetMapping("/topics")
	public String getAllTopics(Model map) {
		System.out.println("in get all topics ");
		map.addAttribute("topic_list", topicService.getAllTopics());
		return "/customer/topics";// AVN : /WEB-INF/views/customer/topics.jsp
	}

	// add req handling method to show tutorials under chosen topic
	@GetMapping("/tutorials")
	public String showTutorialsByTopic(@RequestParam int topicId,Model map) {
		System.out.println("in show tuts " + topicId);
		// invoke service layer method
		map.addAttribute("tut_names", tutorialService.getTutorialsByTopic(topicId));
		return "/customer/tutorials";// LVN ---> AVN /WEB-INF/views/customer/tutorials.jsp
	}
	//add req handling method for getting chosen tut details
	@GetMapping("/tutorial_details")
	public String getTutorialUpdatedDetails(@RequestParam String tut_name,Model map)
	{
		System.out.println("in get tut updated dtls "+tut_name);
		//invoke service layer method
		map.addAttribute("tut_details",tutorialService.getUpdatedTutDetails(tut_name));
		//forward the clnt to view layer
		return "/customer/tutorial_details";//AVN : /WEB-INF/views/customer/tutorial_details.jsp
		
	}

}
