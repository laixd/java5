package com.lai.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.annotation.MultipartConfig;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lai.model.DepartsModel;
import com.lai.model.StaffsModel;
import com.lai.model.services.DepartsExServices;
import com.lai.model.services.StaffsExServices;

@Controller
@RequestMapping("/staffs")
@MultipartConfig(maxFileSize = 1024*1024*1024, maxRequestSize = 1024*1024*1024)
public class StaffsController {
	@Autowired
	private StaffsExServices staffsExServices;

	@Autowired
	private DepartsExServices departsExServices;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(ModelMap model) {
		model.addAttribute("staffsModel", staffsExServices.findAll());
		return "staffs/listStaffs";
	}

	@RequestMapping(value = "/addStaffs", method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("staffsModel", new StaffsModel());
		Iterable<DepartsModel> listDepart = departsExServices.findAll();
		model.addAttribute("listDepart", listDepart);
		return "staffs/addStaffs";
	}

	@RequestMapping(value = "/addStaffs", method = RequestMethod.POST)
	public String add(@Valid StaffsModel staffsModel, BindingResult bindingResult, ModelMap model,
			@RequestParam("aa") String gender, @RequestParam("txtBirthday") Date birthday,
			@RequestParam("txtImage") MultipartFile image,
			@RequestParam("cbodepartID") String departID)
			throws IOException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("staffsModel", staffsModel);
			return "staffs/addStaffs";
		} else {
			model.addAttribute("message", "Thêm thành công");
			model.addAttribute("staffsModel", new StaffsModel());
			StaffsModel staffs = new StaffsModel();
			staffs.setStaffsID(staffsModel.getStaffsID());
			staffs.setStaffsName(staffsModel.getStaffsName());
			if (gender.equalsIgnoreCase("true")) {
				staffs.setGender(true);
			} else {
				staffs.setGender(false);
			}
			staffs.setBirthday(birthday.toLocalDate());
			staffs.setPhoto(image.getBytes());
			staffs.setEmail(staffsModel.getEmail());
			staffs.setPhone(staffsModel.getPhone());
			staffs.setSalary(staffsModel.getSalary());
			staffs.setNotes(staffsModel.getNotes());
			staffs.setDepartID(departsExServices.findById(departID).get());
			staffsExServices.save(staffs);
			return "staffs/addStaffs";
		}

	}

	@RequestMapping(value = "/editStaffs/{staffsID}", method = RequestMethod.GET)
	public String edit(@PathVariable(name = "staffsID") String staffsID, ModelMap model) {
		List<StaffsModel> list = new ArrayList<>();
		Optional<StaffsModel> staffsModel = staffsExServices.findById(staffsID);
		StaffsModel staffs = new StaffsModel();
		if (staffsModel.isPresent()) {
			staffs.setStaffsID(staffsModel.get().getStaffsID());
			staffs.setStaffsName(staffsModel.get().getStaffsName());
			staffs.setGender(staffsModel.get().isGender());
			staffs.setBirthday(staffsModel.get().getBirthday());
			staffs.setPhoto(staffsModel.get().getPhoto());
			staffs.setEmail(staffsModel.get().getEmail());
			staffs.setPhone(staffsModel.get().getPhone());
			staffs.setSalary(staffsModel.get().getSalary());
			staffs.setNotes(staffsModel.get().getNotes());
			staffs.setDepartID(staffsModel.get().getDepartID());
		}
		Iterable<DepartsModel> listDepart = departsExServices.findAll();
		model.addAttribute("listDepart", listDepart);
		model.addAttribute("staffsModel", staffs);
		return "staffs/editStaffs";
	}

	@RequestMapping(value = "/editStaffs", method = RequestMethod.POST)
	public String edit2(@Valid StaffsModel staffsModel, BindingResult bindingResult, @RequestParam("aa") String gender,
			@RequestParam("cbodepartID") String departID,
			@RequestParam("txtBirthday") Date birthday,
			@RequestParam("txtImage") MultipartFile image, ModelMap model) throws IOException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("staffsModel", staffsModel);
			return "staffs/editStaffs";
		} else {
			StaffsModel staffs = new StaffsModel();
			staffs.setStaffsID(staffsModel.getStaffsID());
			staffs.setStaffsName(staffsModel.getStaffsName());
			if (gender.equalsIgnoreCase("true")) {
				staffs.setGender(true);
			} else {
				staffs.setGender(false);
			}
			staffs.setBirthday(birthday.toLocalDate());
			staffs.setPhoto(image.getBytes());
			staffs.setEmail(staffsModel.getEmail());
			staffs.setPhone(staffsModel.getPhone());
			staffs.setSalary(staffsModel.getSalary());
			staffs.setNotes(staffsModel.getNotes());
			staffs.setDepartID(departsExServices.findById(departID).get());
			staffsExServices.save(staffs);
			return "redirect:/staffs";
		}

	}

	@RequestMapping(value = "/delete/{staffsID}", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "staffsID") String staffsID) {
		Optional<StaffsModel> staffsModel = staffsExServices.findById(staffsID);
		if (staffsModel.isPresent()) {
			staffsExServices.deleteById(staffsID);
		}
		return "redirect:/staffs";
	}
}
