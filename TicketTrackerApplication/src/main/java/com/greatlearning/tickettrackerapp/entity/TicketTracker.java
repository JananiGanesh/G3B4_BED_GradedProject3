package com.greatlearning.tickettrackerapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ticket_tracker_db")
public class TicketTracker {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticket_id")
	int ticketId;
	@Column(name = "ticket_title")
	String ticketTitle;
	@Column(name = "ticket_short_description")
	String ticketShortDescription;
	@Column(name = "ticket_created_on")
	@Temporal(TemporalType.DATE)
	Date ticketCreatedOn;
	@Column(name = "ticket_content")
	String ticketContent;

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getTicketTitle() {
		return ticketTitle;
	}

	public void setTicketTitle(String ticketTitle) {
		this.ticketTitle = ticketTitle;
	}

	public String getTicketShortDescription() {
		return ticketShortDescription;
	}

	public void setTicketShortDescription(String ticketShortDescription) {
		this.ticketShortDescription = ticketShortDescription;
	}

	public Date getTicketCreatedOn() {
		return ticketCreatedOn;
	}

	public void setTicketCreatedOn(Date ticketCreatedOn) {
		this.ticketCreatedOn = ticketCreatedOn;
	}

	public String getTicketContent() {
		return ticketContent;
	}

	public void setTicketContent(String ticketContent) {
		this.ticketContent = ticketContent;
	}

}
