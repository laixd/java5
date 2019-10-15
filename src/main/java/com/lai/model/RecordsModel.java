package com.lai.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "records")
public class RecordsModel {
	@Id
	
	private String recordsID;
	
	private boolean type;
	
	@NotEmpty(message = "Không được để trống reason")
	private String reason;
	
	private LocalDate date;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "staffId", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private StaffsModel staffsID;

	public RecordsModel() {

	}

	public RecordsModel(String recordsID, boolean type, @NotEmpty(message = "Không được để trống reason") String reason,
			LocalDate date, StaffsModel staffsID) {
		super();
		this.recordsID = recordsID;
		this.type = type;
		this.reason = reason;
		this.date = date;
		this.staffsID = staffsID;
	}

	public String getRecordsID() {
		return recordsID;
	}

	public void setRecordsID(String recordsID) {
		this.recordsID = recordsID;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public StaffsModel getStaffsID() {
		return staffsID;
	}

	public void setStaffsID(StaffsModel staffsID) {
		this.staffsID = staffsID;
	}

	
}
