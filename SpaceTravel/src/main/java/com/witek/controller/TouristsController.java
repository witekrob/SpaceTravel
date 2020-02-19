package com.witek.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.witek.model.Flight;
import com.witek.model.Sex;
import com.witek.model.Tourist;
import com.witek.repo.ReservationRepo;
import com.witek.repo.TouristRepo;
import com.witek.service.TouristService;

@Controller
public class TouristsController {
	private boolean reservationGenerated=false;
	private TouristService touristService;
	private TouristRepo touristRepo;
	private ReservationRepo reserRepo;
	@Autowired
	public TouristsController(TouristService tService, TouristRepo touristRepo, ReservationRepo reserRepo) {
		this.touristService = tService;
		this.touristRepo = touristRepo;
		this.reserRepo=reserRepo;
		
	}

	private  boolean getReservations() {
		reserRepo.generateReservations();
		reservationGenerated= true;
		return true;
	}
	
	@GetMapping("/passangersmanager")
	public String getAllTourists(Model model, HttpServletRequest request) {
		if (reservationGenerated==false) {
			getReservations();
		}
		List<Tourist> touristsList = new ArrayList<Tourist>();
		touristsList = touristService.getAllTourists();
		model.addAttribute("touristsList", touristsList);
		request.getSession().setAttribute("touristsList", touristsList);
		return "passangersmanager";
	}

	@GetMapping("/showInfoAboutTourist")
	public String getOneTourist(Long tourist_id, Model model) {
		Tourist tourist = touristService.getOneTouristById(tourist_id);
		System.out.println("A OTO ON:  " + tourist);
		model.addAttribute("tourist", tourist);
		return "touristpage";
	}

	@GetMapping("/removeTourist/{tourist_id}")
	public String removeTourist(@PathVariable Long tourist_id) {

		Tourist tourist = touristService.getOneTouristById(tourist_id);
		touristService.removeTourist(tourist);
		return "success";
	}
}
