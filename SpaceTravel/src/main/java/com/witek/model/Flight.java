package com.witek.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.witek.model.Tourist;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long flightId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfDeparture;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfArrival;
	private int flightCapacity;
	private double flightPrice;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "flights")
	private List<Tourist> listOfTourists;

	public Flight() {
	}

	public Flight(Long flightId, Date dateOfDeparture, Date dateOfArrival, int flightCapacity, double flightPrice,
			List<Tourist> listOfTourists) {
		this.flightId = flightId;
		this.dateOfDeparture = dateOfDeparture;
		this.dateOfArrival = dateOfArrival;
		this.flightCapacity = flightCapacity;
		this.listOfTourists = listOfTourists;
		this.listOfTourists = new ArrayList<>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfArrival == null) ? 0 : dateOfArrival.hashCode());
		result = prime * result + ((dateOfDeparture == null) ? 0 : dateOfDeparture.hashCode());
		result = prime * result + flightCapacity;
		result = prime * result + ((flightId == null) ? 0 : flightId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(flightPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((listOfTourists == null) ? 0 : listOfTourists.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (dateOfArrival == null) {
			if (other.dateOfArrival != null)
				return false;
		} else if (!dateOfArrival.equals(other.dateOfArrival))
			return false;
		if (dateOfDeparture == null) {
			if (other.dateOfDeparture != null)
				return false;
		} else if (!dateOfDeparture.equals(other.dateOfDeparture))
			return false;
		if (flightCapacity != other.flightCapacity)
			return false;
		if (flightId == null) {
			if (other.flightId != null)
				return false;
		} else if (!flightId.equals(other.flightId))
			return false;
		if (Double.doubleToLongBits(flightPrice) != Double.doubleToLongBits(other.flightPrice))
			return false;
		if (listOfTourists == null) {
			if (other.listOfTourists != null)
				return false;
		} else if (!listOfTourists.equals(other.listOfTourists))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", dateOfDeparture=" + dateOfDeparture + ", dateOfArrival="
				+ dateOfArrival + ", flightCapacity=" + flightCapacity + ", flightPrice=" + flightPrice
				+ ", listOfTourists=" + listOfTourists + "]";
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlight_id(Long flightId) {
		this.flightId = flightId;
	}

	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	public Date getDateOfArrival() {
		return dateOfArrival;
	}

	public void setDateOfArrival(Date dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}

	public int getFlightCapacity() {
		return flightCapacity;
	}

	public void setFlightCapacity(int flightCapacity) {
		this.flightCapacity = flightCapacity;
	}

	public double getFlightPrice() {
		return flightPrice;
	}

	public void setFlightPrice(double flightPrice) {
		this.flightPrice = flightPrice;
	}

	public List<Tourist> getListOfTourists() {
		return listOfTourists;
	}

	public void setListOfTourists(List<Tourist> listOfTourists) {
		this.listOfTourists = listOfTourists;
	}

}
