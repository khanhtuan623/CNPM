package com.tdt.carrental.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "SHOPPINGCART")
public class ShoppingCart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IdNo")
	private int idNo;

	@Column(name = "DateOfDeparture")
	private String dateOfDeparture;
	
	@Column(name = "IdTicket")
	private int idTicket;

	@Column(name="Chair")
	private String chair;
	
	@Column(name="Total")
	private int total;
	
	@Column(name="Tel")
	private String tel;
	
	@Column(name="IdMethod")
	private String idMethod;
	
	@Column(name="Status")
	private String status;

	public int getIdNo() {
		return idNo;
	}

	public void setIdNo(int idNo) {
		this.idNo = idNo;
	}

	public String getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(String dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	public int getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public String getChair() {
		return chair;
	}

	public void setChair(String chair) {
		this.chair = chair;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getIdMethod() {
		return idMethod;
	}

	public void setIdMethod(String idMethod) {
		this.idMethod = idMethod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
