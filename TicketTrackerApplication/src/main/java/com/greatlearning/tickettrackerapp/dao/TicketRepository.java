package com.greatlearning.tickettrackerapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatlearning.tickettrackerapp.entity.TicketTracker;

public interface TicketRepository extends JpaRepository<TicketTracker, Integer> {

	@Query(value = "SELECT * FROM ticket_tracker_db t WHERE t.ticket_title like %?1% or t.ticket_short_description "
			+ "like %?1% ", nativeQuery = true)
	List<TicketTracker> findByTitleOrDescription(String query);

}
