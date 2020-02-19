package com.witek.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.witek.model.Flight;


@Repository
public interface FlightDao extends JpaRepository<Flight, Long>{

}
