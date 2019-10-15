package com.lai.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lai.model.DepartsModel;
import com.lai.model.StaffsModel;
import com.lai.model.services.DepartsExServices;
import com.lai.model.services.StaffsExServices;

@Controller
@RequestMapping("/departs")
public class DepartsController {
	@Autowired
	private DepartsExServices departsExServices;

	@Autowired
	private StaffsExServices staffsExServices;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(ModelMap model) {
		model.addAttribute("departsModel", departsExServices.findAll());
		return "departs/listDeparts";
	}

	@RequestMapping(value = "/addDeparts", method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("departsModel", new DepartsModel());
		return "departs/addDeparts";
	}

	@RequestMapping(value = "/addDeparts", method = RequestMethod.POST)
	public String add(@Valid DepartsModel departsModel, BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("departsModel", departsModel);
			return "departs/addDeparts";
		} else {
			model.addAttribute("message", "Thêm mới thành công");
			model.addAttribute("departsModel", new DepartsModel());
			DepartsModel departs = new DepartsModel();
			departs.setDepartID(departsModel.getDepartID());
			departs.setDepartsName(departsModel.getDepartsName());
			departsExServices.save(departs);
			return "departs/addDeparts";
		}

	}

	@RequestMapping(value = "/view/{departID}", method = RequestMethod.GET)
	public String view(@PathVariable(name = "departID") String departID, ModelMap model) {
		DepartsModel departsModel = departsExServices.findById(departID).get();
		List<StaffsModel> staffsModel = staffsExServices.findAllByDepartID(departsModel);
		model.addAttribute("staffsModel", staffsModel);
		return "departs/viewDeparts";
	}

	
	
	@RequestMapping(value = "/editDeparts/{departID}", method = RequestMethod.GET)
	public String edit(@PathVariable(name = "departID") String departID, ModelMap model) {
		List<DepartsModel> list = new ArrayList<>();
		Optional<DepartsModel> departsModel = departsExServices.findById(departID);
		DepartsModel departs = new DepartsModel();
		if (departsModel.isPresent()) {
			departs.setDepartID(departsModel.get().getDepartID());
			departs.setDepartsName(departsModel.get().getDepartsName());
		}
		model.addAttribute("departsModel", departs);
		return "departs/editDeparts";
	}

	@RequestMapping(value = "/editDeparts", method = RequestMethod.POST)
	public String edit2(@Valid DepartsModel departsModel, BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("departsModel", departsModel);
			return "departs/editDeparts";
		} else {
			DepartsModel departs = new DepartsModel();
			departs.setDepartID(departsModel.getDepartID());
			departs.setDepartsName(departsModel.getDepartsName());
			departsExServices.save(departs);

			return "redirect:/departs";

		}

	}

	@RequestMapping(value = "/delete/{departID}", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "departID") String departID) {
		Optional<DepartsModel> departsModel = departsExServices.findById(departID);
		if (departsModel.isPresent()) {
			departsExServices.deleteById(departID);
		}
		return "redirect:/departs";
	}
}
