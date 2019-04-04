package com.tdt.carrental.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "CAR")
public class Car implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IdCar")
	private String idCar;

	@Column(name = "Driver1")
	private int driver1;

	@Column(name = "Driver2")
	private int driver2;

	@Column(name = "Other")
	private String other;

	public String getIdCar() {
		return idCar;
	}

	public void setIdCar(String idCar) {
		this.idCar = idCar;
	}

	public int getDriver1() {
		return driver1;
	}

	public void setDriver1(int driver1) {
		this.driver1 = driver1;
	}

	public int getDriver2() {
		return driver2;
	}

	public void setDriver2(int driver2) {
		this.driver2 = driver2;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	

}
