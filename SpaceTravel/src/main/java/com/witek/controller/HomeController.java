package com.witek.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.witek.model.Flight;
import com.witek.repo.FlightRepo;
import com.witek.repo.ReservationRepo;
import com.witek.repo.TouristRepo;
import com.witek.dao.FlightDao;
import com.witek.service.FlightListService;
import com.witek.service.TouristService;

@Controller
public class HomeController {
private ReservationRepo reserRepo;
private TouristRepo touristRepo;
private FlightRepo flightRepo;

@Autowired
public HomeController(TouristRepo tRepo, FlightRepo flightRepo) {
	this.flightRepo=flightRepo;
	this.touristRepo=touristRepo;
	tRepo.generateTourists();
	flightRepo.generateFlights();
}
	@GetMapping("/")
	public String goHome(Model model) {		
		return "index";
	}
	@GetMapping("error")
	 public String errorPage() {
		 return "error";
	 }
}
