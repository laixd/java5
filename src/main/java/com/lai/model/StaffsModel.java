package com.lai.model;

import java.time.LocalDate;
import java.util.Base64;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "staffs")
public class StaffsModel {
	@Id
	@Size(min = 4, max = 4, message = "Độ dài StaffsID đúng 4 kí tự")
	private String staffsID;

	private String staffsName;

	private boolean gender;

	private LocalDate birthday;

	@Lob
	private byte[] photo;

	@Email(message = "Mail không đúng định dạng")
	private String email;

	@Size(min=10, max = 11, message="Độ dài phone 10 hoặc 11 số")
	private String phone;

	@DecimalMin(value = "1", message = "salary phải lớn hơn 0")
	private Double salary;

	private String notes;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "departId", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private DepartsModel departID;

	public StaffsModel() {
	}

	public StaffsModel(String staffsID, String staffsName, boolean gender, LocalDate birthday, byte[] photo,
			String email, @NotEmpty(message = "Không được để trống phone") String phone,
			@NotNull(message = "Không được để trống salary") @DecimalMin(value = "1", message = "salary phải lớn hơn 0") Double salary,
			String notes, DepartsModel departID) {
		super();
		this.staffsID = staffsID;
		this.staffsName = staffsName;
		this.gender = gender;
		this.birthday = birthday;
		this.photo = photo;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
		this.notes = notes;
		this.departID = departID;
	}

	public String getStaffsID() {
		return staffsID;
	}

	public void setStaffsID(String staffsID) {
		this.staffsID = staffsID;
	}

	public String getStaffsName() {
		return staffsName;
	}

	public void setStaffsName(String staffsName) {
		this.staffsName = staffsName;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public DepartsModel getDepartID() {
		return departID;
	}

	public void setDepartID(DepartsModel departID) {
		this.departID = departID;
	}

	public String getImage(byte[] image) {
		return Base64.getEncoder().encodeToString(image);
	}

}
