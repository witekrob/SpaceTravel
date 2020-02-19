package com.witek.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Tourist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tourist_id;
	private String name;
	private String surname;
	private Sex sex;
	private String country;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	private String notes;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Flight> flights;

	public Tourist() {
	}

	public Tourist(Long tourist_id, String name, String surname, Sex sex, String country, Date dateOfBirth, String notes,
			List<Flight> flights) {
		this.tourist_id = tourist_id;
		this.name = name;
		this.surname = surname;
		this.sex = sex;
		this.country = country;
		this.dateOfBirth = dateOfBirth;
		this.notes = notes;
		this.flights = flights;
		this.flights = new ArrayList<>();
	}

	public Long getTourist_id() {
		return tourist_id;
	}

	public void setTourist_id(Long tourist_id) {
		this.tourist_id = tourist_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((flights == null) ? 0 : flights.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((tourist_id == null) ? 0 : tourist_id.hashCode());
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
		Tourist other = (Tourist) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (flights == null) {
			if (other.flights != null)
				return false;
		} else if (!flights.equals(other.flights))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (sex != other.sex)
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (tourist_id == null) {
			if (other.tourist_id != null)
				return false;
		} else if (!tourist_id.equals(other.tourist_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tourist [tourist_id=" + tourist_id + ", name=" + name + ", surname=" + surname + ", sex=" + sex
				+ ", country=" + country + ", dateOfBirth=" + dateOfBirth + ", notes=" + notes + "]";
	}



}
