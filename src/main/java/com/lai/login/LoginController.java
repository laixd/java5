package com.lai.login;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lai.model.UsersModel;
import com.lai.model.services.UsersExServices;

@Controller
@RequestMapping("/authenticate")
public class LoginController {
	@Autowired
	private UsersExServices usersExServices;

	@PostMapping("/login")
	public String login(@ModelAttribute("UsersModel") @Valid UsersModel userModel, BindingResult bindingResult,
			ModelMap model, HttpSession session) {
		model.addAttribute("UsersModel", userModel);
		if (!usersExServices.existsById(userModel.getUsername())) {
			model.addAttribute("username_error", "Tên đăng nhập sai !");
		return "users/login";
	}
		UsersModel userModels = usersExServices.findById(userModel.getUsername()).get();
		if (!userModel.getPassword().equals(userModels.getPassword())) {
			model.addAttribute("password_error", "Mật khẩu không đúng  !");
			return "users/login";
		}
		session.setAttribute("UsersModel", userModels);
		return "redirect:/staffs";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		model.addAttribute("UsersModel", new UsersModel());
		return "users/login";
	}
//	@RequestMapping(value = "", method = RequestMethod.GET)
//	public String home(ModelMap model) {
//		model.addAttribute("UsersModel", new UsersModel());
//		return "redirect:users/login";
//	}
//
//	@RequestMapping(value = "", method = RequestMethod.POST)
//	public String login(@Valid @ModelAttribute UsersModel usersModel, BindingResult bindingResult, ModelMap model) {
//		boolean a = false;
//			Optional<UsersModel> users = usersExServices.findById(usersModel.getUsername());
//			if (users.isPresent()) {
//				if ((usersModel.getUsername().equals(users.get().getUsername())
//						&& (usersModel.getPassword().equals(users.get().getPassword())))) {
//					a = true;
//				}
//			}
//		if (a) {
//			model.addAttribute("usersModel", usersModel);
//			return "redirect:/staffs";
//		} else {
//			model.addAttribute("usersModel", usersModel);
//			System.out.println("saiiiiiiiii");
//			model.addAttribute("message", " Username hoặc Password không đúng, vui lòng đăng nhập lại !!!");
//			return "users/login";
//		}
//	}
}
