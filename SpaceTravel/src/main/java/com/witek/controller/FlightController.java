package com.witek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.witek.model.Flight;
import com.witek.model.Tourist;
import com.witek.repo.FlightRepo;
import com.witek.service.FlightListService;
import com.witek.service.TouristService;

@Controller
public class FlightController {

	private FlightListService flightService;
	private TouristService touristService;
	private FlightRepo flightRepo;
	@Autowired
	public FlightController(FlightListService fService, TouristService touristService, FlightRepo flightRepo) {
		this.flightService = fService;
		this.touristService = touristService;
		this.flightRepo=flightRepo;
	}

	@GetMapping("/flights")
	public String showAllFLights(Model model) {
		Flight flight = new Flight();
		
		List<Flight> flightsList = flightService.getListOfAllFlights();
		model.addAttribute("flightsList", flightsList);
		model.addAttribute("flight", flight);
		return "allFlights";
	}

	@GetMapping("/showInfoAboutFlight")
	public String showOneFlight(Long flightId, Model model) {
		Flight flight = flightService.getOneFlightById(flightId);
		model.addAttribute("flight", flight);
		return "flightpage";
	}
	
	
	
	@PostMapping("/flights")
	public String createNewFlight(@ModelAttribute Flight flight) {
		flightService.createNewFLight(flight);
		return "allFlights";
	}

	@GetMapping("/removeFromFlightList")
	public String removeFromFlightList(HttpServletRequest request) {
		String touristIdString = request.getParameter("tourist_id");
		String flightIdString = request.getParameter("flightId");
		System.out.println("PARAMETRY : " + touristIdString + " " + flightIdString);

		Long tourist_id = Long.parseLong(touristIdString);
		Long flightId = Long.parseLong(flightIdString);
		System.out.println(tourist_id + " " + flightId);
		Tourist tourist = touristService.getOneTouristById(tourist_id);
		flightService.removeTouristFromFlight(tourist, flightId);

		return "index";
	}

}
