package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.User;
import com.app.pojos.UserRole;
import com.app.service.IUserService;



@Controller
@RequestMapping("/user") // => all user related actions(common to admin n customer) will be mapped here
public class UserController {
	// dependency : service layer i/f
	@Autowired // byType
	private IUserService userService;
//	@Autowired
//	private ITopicService topicService;

	public UserController() {
		System.out.println("in ctor of " + getClass());
	}

	// add request handling method to forward the clnt to the login form. : show
	// form phase
	@GetMapping("/login")
	public String showLoginFrom() {
		System.out.println("in show login form");
		return "/user/login";// AVN : /WEB-INF/views/user/login.jsp
	}

	// add a request handling method to process login form
	// @RequestParam : method arg level annotation , to bind req params ---> method
	// args
	// SC invokes : String email=request.getParameter("email");
	@PostMapping("/login") // @RequestMapping + method=POST
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model map,
			HttpSession session) {
		System.out.println("in process login form " + email + " " + password + " " + map);
		try {
			// controller has to invoke service layer method --for exec of B.L
			User user = userService.authenticateUser(email, password);// in case of success : DETACHED pojo
			// in case of invalid login :
			// => valid login
			// add validated user details , under Model map
			session.setAttribute("user_details", user);
			if (user.getRole() == UserRole.CUSTOMER) {
				// invoke topic service method to get list of all topics --save it in Model map
				// .
				// map.addAttribute("topic_list", topicService.getAllTopics());
				return "redirect:/customer/topics";// UserController sends to D.S : redirect view name
				// skips V.R ,
				// response.sendRedirect(response.encodeRedirectURL("customer/topics"));
				// sends temp resp pkt : SC 302 | Location : customer/topics , set-cookie :
				// JSESSIONID : dfgsdf546735, | Body : EMPTY
				// clnt browser : sends new request :
				// http://host:port/day16_spring_mvc/customer/topics
			}
			// admin login :
			return "redirect:/admin/welcome";// redirect view name , D.S skips  V.R --sends temp redirect resp
			//next request will be sent form clnt browser : http://host:port/spring-mvc-boot/admin/welcome
			//method = GET

		} catch (RuntimeException e) {
			System.out.println("err in class " + getClass() + "in  process login form " + e);// NoResultExc
			// add err mesg in the model map
			map.addAttribute("message", "Invalid Login , Please retry.....");
			return "/user/login";// in case of invalid login ---> forward clnt to login page + err mesg
			// implicitly : map --model attr : message
		}

	}

	// add request habdling method for user's logout
	@GetMapping("/logout")
	public String userLogout(HttpSession session, Model map, HttpServletRequest request, HttpServletResponse resp) {
		System.out.println("in user logout");
		// copy session scoped attribute under model map
		map.addAttribute("user_dtls", session.getAttribute("user_details"));
		// discard session
		session.invalidate();
		// auto redirect clnt to index page , after some delay
		resp.setHeader("refresh", "5;url="+request.getContextPath());
		return "/user/logout";//AVN resolved by V.R : /WEB-INF/views/user/logout.jsp
	}

}
