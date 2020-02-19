package com.witek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.witek.model.Flight;
import com.witek.model.Tourist;
import com.witek.service.FlightListService;
import com.witek.service.TouristService;

@Controller
public class ReservationController {

	private FlightListService fService;
	private TouristService tService;

	@Autowired
	public ReservationController(FlightListService fService, TouristService tService) {
		this.fService = fService;
		this.tService = tService;
	}
@GetMapping("/reservation")
public String reservation(Model model, HttpServletRequest request) {
	List<Flight> flightsList = fService.getListOfAllFlights();
	List<Tourist> touristsList = tService.getAllTourists(); 
	model.addAttribute("flightsList", flightsList);
	model.addAttribute("touristsList", touristsList);
	return "reservation";
}
@PostMapping("/makeReservation")
public String addPassangerToFlight(Long tourist_id, Long flightId, HttpServletRequest request) {
	Tourist tourist = tService.getOneTouristById(tourist_id);
	Flight flight = fService.getOneFlightById(flightId);
	System.out.println(tourist.getName() + " " + flight.getFlightPrice());
	String result = tService.addFlightToTourist(tourist.getTourist_id(), flight);
	if (result=="Success") {
	return "success";
	}
	else {
		return "error";
	}
}

}
