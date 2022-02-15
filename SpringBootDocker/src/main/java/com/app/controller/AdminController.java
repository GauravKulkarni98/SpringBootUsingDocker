package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Tutorial;
import com.app.service.ITopicService;
import com.app.service.ITutorialService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	// dependency : Topic service i/f
	@Autowired
	private ITopicService topicService;
	@Autowired
	private ITutorialService tutorialService;

	public AdminController() {
		System.out.println("in ctor of " + getClass());
	}

	// add request handling method to forward the clnt to admin welcome page
	@GetMapping("/welcome")
	public String showAdminWelcomePage(Model map) {
		System.out.println("in show admin welcome page");
		map.addAttribute("topic_list", topicService.getAllTopics());
		return "/admin/welcome";// AVN : /WEB-INF/view/admin/welcome.jsp
	}

	// http://localhost:9090/spring-mvc-boot/admin/tutorial_list?topicDetails=1%3AServlets
	// add request handling method to forward the clnt to tut list page
	@GetMapping("/tutorial_list")
	public String showTutsBySelectedTopic(@RequestParam String topicDetails, Model map, HttpSession session) {
		System.out.println("in show tuts by topic id " + topicDetails);// 1:Servlets
		int topicId = Integer.parseInt(topicDetails.split(":")[0]);
		String topicName = topicDetails.split(":")[1];
		System.out.println(topicId + " " + topicName);
		// store topic details under sesison scope
		session.setAttribute("selected_topic_id", topicId);
		session.setAttribute("selected_topic_name", topicName);
		// get list of tutorial undet selected topic id
		map.addAttribute("tut_list", tutorialService.getTutorialsByTopic(topicId));
		return "/admin/tutorial_list";
	}

	// add new method , to show the form for adding a new tutorial
	@GetMapping("/add_tutorial")

	public String showAddTutorialForm(@RequestParam int topicId, Tutorial tut) // can be alternatively taken from
																				// HttpSession
	{
		// SC creates EMPTY POJO instance (i.e Tutorial instance) n adds it in Model
		// attribute map
		// map.addAttribute("tutorial",new Tutorial());
		System.out.println("in show add tut form " + topicId);
		return "/admin/add_tutorial";
	}

	// add new method , to process the form : post
	// URL : http://host:port/spring-mvc-boot/admin/add_tutorial
	@PostMapping("/add_tutorial")
	public String processTutorialForm(/* @ModelAttribute(name="tutorial") */ Tutorial tut1, Model map,
			HttpSession session) {
		System.out.println("in process form " + tut1);// If form binding(form data : req params ---> popjo props via
														// setters ,except id , topic , all properties should be set.
		System.out.println("topic " + tut1.getTopic());// null
		// invoke service layer method
		map.addAttribute("message",
				tutorialService.addNewTutorial(tut1, (Integer) session.getAttribute("selected_topic_id")));
		return "/admin/added_tut";
	}

}
