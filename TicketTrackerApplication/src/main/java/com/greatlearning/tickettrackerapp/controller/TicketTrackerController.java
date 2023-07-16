package com.greatlearning.tickettrackerapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.tickettrackerapp.entity.TicketTracker;
import com.greatlearning.tickettrackerapp.service.TicketService;

@Controller
@RequestMapping("/tickettracker")
public class TicketTrackerController {

	@Autowired
	TicketService service;

	@GetMapping("/")
	public String getAllTickets(Model model) {
		model.addAttribute("tickets", service.getAllTickets());
		return "tickets_withmenu";
	}

	@GetMapping("/search")
	public String searchTickets(Model model, @RequestParam("query") String query) {
		List<TicketTracker> listTickets = service.searchTickets(query);
		model.addAttribute("tickets", listTickets);
		return "tickets_withmenu";
	}

	@GetMapping("/tickets")
	public String getTickets(Model model) {
		model.addAttribute("tickets", service.getAllTickets());
		return "tickets";
	}

	@GetMapping("/new")
	public String addTicket(Model model) {
		model.addAttribute("ticket", new TicketTracker());
		return "new_ticket";

	}

	@GetMapping("/edit/{id}")
	public String editTicket(@PathVariable(name = "id") Integer id, Model model) {
		model.addAttribute("ticket", service.getTicketByID(id));

		return "edit_ticket";

	}

	@GetMapping("/delete/{id}")
	public String deleteTicket(@PathVariable(name = "id") Integer id) {
		service.deleteByTicketId(id);
		return "redirect:/tickettracker/";

	}

	@PostMapping("/save")
	public String createTicket(@ModelAttribute(name = "ticket") TicketTracker ticket) {
		service.saveTicket(ticket);
		return "redirect:/tickettracker/";

	}

	@PostMapping("/save/{id}")
	public String createTicket(@PathVariable(name = "id") Integer id,
			@ModelAttribute(name = "ticket") TicketTracker ticket) {
		ticket.setTicketId(id);
		service.saveTicket(ticket);
		return "redirect:/tickettracker/";
	}

	@GetMapping("/view/{id}")
	public String searchTicket(@PathVariable(name = "id") Integer id, Model model) {
		model.addAttribute("ticket", service.getTicketByID(id));

		return "view_ticket";

	}

}
