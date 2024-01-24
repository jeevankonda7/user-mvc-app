package org.olympus.usermvcapp.controller;

import java.util.List;

import org.olympus.usermvcapp.dao.UserDao;
import org.olympus.usermvcapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/")
	public String show(Model model) {
		List<User> users = userDao.findAll();
		model.addAttribute("user", users);
		return "display";
	}

	@RequestMapping(value = "/create")
	public ModelAndView loadPage(String page, ModelAndView view) {
		view.setViewName("create");
		view.addObject("user", new User());
		return view;
	}

	@RequestMapping("/save")
	public String save(@ModelAttribute User user) {
		if (user.getId() == null) {
			userDao.save(user);
		} else {
			userDao.update(user);
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/update")
	public ModelAndView update(@RequestParam int id, ModelAndView view) {
		User u = userDao.find(id);
		view.setViewName("create");
		view.addObject("user", u);
		return view;
	}
	
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam int id) {
		userDao.delete(id);
		return "redirect:/";
	}
}
