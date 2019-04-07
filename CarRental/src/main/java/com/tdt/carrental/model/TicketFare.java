package com.tdt.carrental.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="TICKETFARE")
public class TicketFare implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IdTicket")
	private int idTicket;
	
	@Column(name="IdSchedule")
	private int idSchedule;
	
	@Column(name="StartingPost")
	private String startingPost;
	
	@Column(name="Destination")
	private String destination;
	
	@Column(name="Price")
	private int price;
	
	@Column(name="Note")
	private String note;

	public int getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public int getIdSchedule() {
		return idSchedule;
	}

	public void setIdSchedule(int idSchedule) {
		this.idSchedule = idSchedule;
	}

	public String getStartingPost() {
		return startingPost;
	}

	public void setStartingPost(String startingPost) {
		this.startingPost = startingPost;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
