package com.witek.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.witek.model.Flight;
import com.witek.model.Tourist;
import com.witek.service.FlightListService;
import com.witek.service.TouristService;

@Repository
public class ReservationRepo {

	public FlightListService flightService;
	public TouristService touristService;

	@Autowired
	public ReservationRepo(FlightListService fService, TouristService tService) {
		this.flightService = fService;
		this.touristService = tService;
	}

	public void generateReservations() {
		List<Tourist> tourists = touristService.getAllTourists();
		List<Flight> flights = flightService.getListOfAllFlights();
		Tourist t = new Tourist();
		Flight f = new Flight();
		for (int i = 0; i < 100; i++) {
			
			t = tourists.get(i);
			f = flights.get(i);
			touristService.addFlightToTourist(t.getTourist_id(), f);
		System.out.println(f+ " " + t);
		}
	}
}
