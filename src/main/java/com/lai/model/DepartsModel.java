package com.lai.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name="departs")
public class DepartsModel {
	@Id
	
	@Basic
	@Nationalized
	private String departID;
	
	@Basic
	@Nationalized
	private String departsName;

	public DepartsModel() {
	}

	public DepartsModel(String departID, String departsName) {
		super();
		this.departID = departID;
		this.departsName = departsName;
	}

	public String getDepartID() {
		return departID;
	}

	public void setDepartID(String departID) {
		this.departID = departID;
	}

	public String getDepartsName() {
		return departsName;
	}

	public void setDepartsName(String departsName) {
		this.departsName = departsName;
	}


}
