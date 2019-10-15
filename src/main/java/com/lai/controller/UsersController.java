package com.lai.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lai.model.UsersModel;
import com.lai.model.services.UsersExServices;

@Controller
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersExServices usersExServices;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(ModelMap model) {
		model.addAttribute("usersModel", usersExServices.findAll());
		return "users/listUsers";
	}
	
	@RequestMapping(value = "/addUsers", method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("usersModel", new UsersModel());
		return "users/addUsers";
	}

	@RequestMapping(value = "/addUsers", method = RequestMethod.POST)
	public String add(@Valid UsersModel usersModel, BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("usersModel", usersModel);
			return "users/addUsers";
		} else {
			model.addAttribute("message", "them thanh cong");
			model.addAttribute("usersModel", new UsersModel());
			UsersModel users = new UsersModel();
			users.setUsername(usersModel.getUsername());
			users.setPassword(usersModel.getPassword());
			users.setFullname(usersModel.getFullname());
			usersExServices.save(users);
			return "users/addUsers";
		}

	}

	@RequestMapping(value = "/editUsers/{username}", method = RequestMethod.GET)
	public String edit(@PathVariable(name = "username") String username, ModelMap model) {
		List<UsersModel> list = new ArrayList<>();
		Optional<UsersModel> usersModel = usersExServices.findById(username);
		UsersModel users = new UsersModel();
		if (usersModel.isPresent()) {
			users.setUsername(usersModel.get().getUsername());
			users.setPassword(usersModel.get().getPassword());
			users.setFullname(usersModel.get().getFullname());

		}
		model.addAttribute("usersModel", users);
		return "users/editUsers";
	}

	@RequestMapping(value = "/editUsers", method = RequestMethod.POST)
	public String edit2(@Valid UsersModel usersModel, BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("usersModel", usersModel);
			return "users/editUsers";
		} else {
			UsersModel users = new UsersModel();
			users.setUsername(usersModel.getUsername());
			users.setPassword(usersModel.getPassword());
			users.setFullname(usersModel.getFullname());
			usersExServices.save(users);
			return "redirect:/users";
		}

	}

	@RequestMapping(value = "/delete/{username}", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "username") String username) {
		Optional<UsersModel> usersModel = usersExServices.findById(username);
		if (usersModel.isPresent()) {
			usersExServices.deleteById(username);
		}
		return "redirect:/users";
	}
}
