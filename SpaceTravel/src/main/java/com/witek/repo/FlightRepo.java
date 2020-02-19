package com.witek.repo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.witek.dao.FlightDao;
import com.witek.model.Flight;
@Repository
public class FlightRepo {

	private FlightDao fDao;

	@Autowired
	public FlightRepo(FlightDao fDao) {
		this.fDao = fDao;
	}

	public void generateFlights() {
		DataFactory df = new DataFactory();
		List<Flight> lista = new ArrayList<Flight>();
		Flight[] flightArray = new Flight[100];

		for (int i = 0; i < flightArray.length; i++) {
			flightArray[i] = new Flight();
			flightArray[i].setFlightCapacity(df.getNumberBetween(1, 30));
			flightArray[i].setFlightPrice(df.getNumberBetween(4000, 10000));

			Date minDate = new Date();
			minDate.setYear(2020);
			minDate.setMonth(02);
			minDate.setDate(01);

			Date maxDate = new Date();
			maxDate.setYear(2040);
			maxDate.setMonth(12);
			maxDate.setDate(31);

			flightArray[i].setDateOfArrival(df.getDateBetween(minDate, maxDate));
			flightArray[i].setDateOfDeparture(df.getDateBetween(minDate, maxDate));
			lista.add(flightArray[i]);
		}
		fDao.saveAll(lista);

	}
}