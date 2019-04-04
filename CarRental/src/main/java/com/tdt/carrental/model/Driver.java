package com.tdt.carrental.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DRIVER")
public class Driver implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "IdDriver")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDriver;
	
	@Column(name="NameDriver")
	private String nameDriver;
	
	@Column(name="Tel")
	private String tel;
	
	@Column(name="Experience")
	private String exp;
	
	@Column(name="Other")
	private String other;

	public Long getIdDriver() {
		return idDriver;
	}

	public void setIdDriver(Long idDriver) {
		this.idDriver = idDriver;
	}

	public String getNameDriver() {
		return nameDriver;
	}

	public void setNameDriver(String nameDriver) {
		this.nameDriver = nameDriver;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	
	
	
}
