package com.witek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.witek.dao.FlightDao;
import com.witek.dao.TouristDao;
import com.witek.model.Flight;
import com.witek.model.Tourist;

@Service
public class FlightListService {

	private FlightDao flightDao;
	private TouristDao touristDao;
	@Autowired
	public FlightListService(FlightDao dao,TouristDao touristDao) {
		this.flightDao = dao;
		this.touristDao=touristDao;
	}
	public Flight getOneFlightById(Long id) {
		return flightDao.getOne(id);
	}
	public List<Flight> getListOfAllFlights(){
		return 		flightDao.findAll();		
	}
	public void createNewFLight(Flight flight) {
		flightDao.save(flight);
		
	}
	
	public Flight addtouristToFlight(Tourist tourist, Long id) {
		Flight flight = flightDao.findById(id).get();
		flight.getListOfTourists().add(tourist);
		int capacity = flight.getFlightCapacity();
		capacity--;
		flightDao.save(flight);
		flight.setFlightCapacity(capacity);
		return flight;
	}

	public void removeTouristFromFlight(Tourist tourist, Long id) {
		Flight flight = flightDao.findById(id).get();
		flight.getListOfTourists().remove(tourist);
		int capacity = flight.getFlightCapacity();
		System.out.println(flight);
		System.out.println(tourist);
		capacity++;
		System.out.println("Info from flight controller : "	+ tourist + " removed from this flight");
		tourist.getFlights().remove(flight);
		touristDao.save(tourist);
		flightDao.save(flight);
	}
}
