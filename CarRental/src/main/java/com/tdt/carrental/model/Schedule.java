package com.tdt.carrental.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="SCHEDULE")
public class Schedule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IdSchedule")
	private int idSchedule;
	
	@Column(name="NameChannel")
	private String nameChannel;
	
	@Column(name="Space")
	private String space;
	
	@Column(name="Number")
	private int number;
	
	@Column(name="TimeOfDeparture")
	private String timeOfDeparture;
	
	@Column(name="ArrivalTime")
	private String arrivalTime;
	
	@Column(name="IdCar")
	private String idCar;

	public int getIdSchedule() {
		return idSchedule;
	}

	public void setIdSchedule(int idSchedule) {
		this.idSchedule = idSchedule;
	}

	public String getNameChannel() {
		return nameChannel;
	}

	public void setNameChannel(String nameChannel) {
		this.nameChannel = nameChannel;
	}

	public String getSpace() {
		return space;
	}

	public void setSpace(String space) {
		this.space = space;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTimeOfDeparture() {
		return timeOfDeparture;
	}

	public void setTimeOfDeparture(String timeOfDeparture) {
		this.timeOfDeparture = timeOfDeparture;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getIdCar() {
		return idCar;
	}

	public void setIdCar(String idCar) {
		this.idCar = idCar;
	}
	
	
}
