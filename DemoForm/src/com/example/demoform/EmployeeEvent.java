package com.example.demoform;

import java.util.Date;

/**
 * @author jobina
 * 
 */
public class EmployeeEvent {

	private Long uidpk;
	/**
	 * Employee Id is optional. No employee Id means valid for all employees
	 */
	private Long empId;
	/**
	 * Occasion of the event
	 */
	private String occassion;
	/**
	 * Date of event
	 */
	private Date date;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getUidpk() {
		return uidpk;
	}

	public void setUidpk(Long uidpk) {
		this.uidpk = uidpk;
	}

	public String getOccassion() {
		return occassion;
	}

	public void setOccassion(String occassion) {
		this.occassion = occassion;
	}

}
