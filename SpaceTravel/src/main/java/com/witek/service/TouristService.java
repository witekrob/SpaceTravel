package com.witek.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.witek.dao.TouristDao;
import com.witek.model.Flight;
import com.witek.model.Sex;
import com.witek.model.Tourist;

@Service
public class TouristService {

	private TouristDao tDao;

	@Autowired
	public TouristService(TouristDao dao) {
		this.tDao = dao;
	}

	public List<Tourist> getAllTourists() {
		List<Tourist> touristList = new ArrayList<>();
		touristList = tDao.findAll();
		return touristList;
	}

	public Tourist getOneTouristById(Long id) {
		Tourist tourist = tDao.findById(id).get();
		return tourist;
	}

	public String addFlightToTourist(Long touristId, Flight flight) {
		String message;
		Tourist tourist = tDao.findById(touristId).get();
		if (flight.getFlightCapacity()==0) {
			System.out.println("Sorry, not enough space");
			message="Error";
		}
		else {
		tourist.getFlights().add(flight);
		flight.getListOfTourists().add(tourist);
		flight.setFlightCapacity(flight.getFlightCapacity() - 1);
		tDao.save(tourist);
		message="Success";
		}
		return message;
	}

	public void removeTouristsFlight(Long touristId, Flight flight) {
		Tourist tourist = tDao.findById(touristId).get();
		tourist.getFlights().remove(flight);

	}

	public void createNewTourist(Tourist tourist) {
		System.out.println("Tourist service : " + tourist);
		tDao.save(tourist);
	}

	public void removeTourist(Tourist tourist) {
		System.out.println("TO DELETE : " + tourist);
		tDao.delete(tourist);
	}
}
