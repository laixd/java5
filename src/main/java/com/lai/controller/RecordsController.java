package com.lai.controller;

import java.sql.Date;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.lai.model.RecordsModel;
import com.lai.model.StaffsModel;
import com.lai.model.services.RecordsExServices;
import com.lai.model.services.StaffsExServices;
import com.lai.thongke.nhanvien;

@Controller
@RequestMapping("/records")
public class RecordsController {
	@Autowired
	private RecordsExServices recordsExServices;

	@Autowired
	private StaffsExServices staffsExServices;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(ModelMap model) {
		model.addAttribute("recordsModel", recordsExServices.findAll());
		return "records/listRecords";
	}

	@RequestMapping(value = "/addRecords", method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("recordsModel", new RecordsModel());
		Iterable<StaffsModel> listStaff = staffsExServices.findAll();
		model.addAttribute("listStaff", listStaff);
		return "records/addRecords";
	}

	@RequestMapping(value = "/addRecords", method = RequestMethod.POST)
	public String add(@Valid RecordsModel recordsModel, BindingResult bindingResult, ModelMap model,
			@RequestParam("txtBirthday") Date birthday,
			@RequestParam("cbostaffID") String staffID,
			@RequestParam("radtype") String type) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("recordsModel", recordsModel);
			return "records/addRecords";
		} else {
			model.addAttribute("message", "Thêm thành công !!");
			model.addAttribute("recordsModel", new RecordsModel());
			RecordsModel records = new RecordsModel();
			records.setRecordsID(recordsModel.getRecordsID());
			
			
			if (type.equalsIgnoreCase("true")) {
				records.setType(true);
			} else {
				records.setType(false);
			}
			records.setReason(recordsModel.getReason());
			records.setDate(birthday.toLocalDate());
			records.setStaffsID(staffsExServices.findById(staffID).get());
			recordsExServices.save(records);
			return "records/addRecords";
		}

	}

	@RequestMapping(value = "/editRecords/{recordsID}", method = RequestMethod.GET)
	public String edit(@PathVariable(name = "recordsID") String recordsID, ModelMap model) {
		List<RecordsModel> list = new ArrayList<>();
		Optional<RecordsModel> recordsModel = recordsExServices.findById(recordsID);
		RecordsModel record = new RecordsModel();
		if (recordsModel.isPresent()) {
			record.setRecordsID(recordsModel.get().getRecordsID());
			record.setType(recordsModel.get().isType());
			record.setReason(recordsModel.get().getReason());
			record.setDate(recordsModel.get().getDate());
			record.setStaffsID(recordsModel.get().getStaffsID());
		}
		Iterable<StaffsModel> listStaff = staffsExServices.findAll();
		model.addAttribute("listStaff", listStaff);
		model.addAttribute("recordsModel", record);
		return "records/editRecords";
	}

	@RequestMapping(value = "/editRecords", method = RequestMethod.POST)
	public String edit2(@Valid RecordsModel recordsModel, BindingResult bindingResult, ModelMap model,
			@RequestParam("txtBirthday") Date birthday,
			@RequestParam("cbostaffID") String staffID,
			@RequestParam("radtype") String type) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("recordsModel", recordsModel);
			return "records/editRecords";
		} else {
			RecordsModel records = new RecordsModel();
			records.setRecordsID(recordsModel.getRecordsID());
			if (type.equalsIgnoreCase("true")) {
				records.setType(true);
			} else {
				records.setType(false);
			}
			records.setReason(recordsModel.getReason());
			records.setDate(birthday.toLocalDate());
			records.setStaffsID(staffsExServices.findById(staffID).get());
			recordsExServices.save(records);
			return "redirect:/records";
		}

	}

	@RequestMapping(value = "/delete/{recordsID}", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "recordsID") String recordsID) {
		Optional<RecordsModel> recordsModel = recordsExServices.findById(recordsID);
		if (recordsModel.isPresent()) {
			recordsExServices.deleteById(recordsID);
		}
		return "redirect:/records";
	}
	
	@RequestMapping("/Report")
	public String collect(ModelMap  modelMap) {
		List<nhanvien> tongHopNhanVien = recordsExServices.fetchRecordEmp();
		modelMap.addAttribute("records", tongHopNhanVien);
		modelMap.addAttribute("record", recordsExServices.fillThanhtich());
		return "records/tonghop";
		
	}
}
