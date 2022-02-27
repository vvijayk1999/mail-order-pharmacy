package io.github.vvijayk1999.mailorderpharmacy.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import io.github.vvijayk1999.mailorderpharmacy.exceptions.UsernameAlreadyExistsException;
import io.github.vvijayk1999.mailorderpharmacy.models.User;
import io.github.vvijayk1999.mailorderpharmacy.services.CommonService;
import io.github.vvijayk1999.mailorderpharmacy.services.MyUserDetailsService;

@Controller
public class ProtalController {

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private CommonService commonService;

	@RequestMapping("/")
	public String displayApp() {
		if (commonService.getLoggedinEmailId() == "anonymousUser") {
			return "index";
		}
		return "redirect:/home";
	}

	@RequestMapping("/home")
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView("welcome");

		model.addObject("username", commonService.getLoggedinUsername());

		return model;
	}

	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping("/logout-success")
	public String logoutPage(Model model) {
		String messageTags = "<h2>Logout Successful</h2> \r\n"
				+ "	        <h3>Thank you for using our services....</h3>\r\n"
				+ "	        <p>Redirecting to home in moment</p>";
		model.addAttribute("messageTags", messageTags);
		model.addAttribute("title", "Logout | Mail Order Pharmacy");
		return "popup";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Model model, @Valid @ModelAttribute User user, BindingResult result) {

		if (result.hasErrors()) {
//			System.out.println(result);
			return "register";
		}

		try {
			userDetailsService.save(user);
		} catch (UsernameAlreadyExistsException e) {
			model.addAttribute("errorMessage", e.getLocalizedMessage());
			return "register";
		}
		String messageTags = "<h2>Registered Successful</h2> \r\n" + "	        <p>Redirecting to home in moment</p>";
		model.addAttribute("messageTags", messageTags);
		model.addAttribute("title", "Registered Successfully");

		return "popup";
	}
}
