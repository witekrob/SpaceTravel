package com.witek.repo;

import java.util.ArrayList;
import java.util.List;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.witek.dao.TouristDao;
import com.witek.model.Sex;
import com.witek.model.Tourist;

@Repository
public class TouristRepo {
public TouristDao tDao;


@Autowired
public TouristRepo(TouristDao tDao) {
	this.tDao=tDao;
}
	public void generateTourists() {	
		DataFactory df = new DataFactory();
		List<Tourist> lista = new ArrayList<Tourist>();
		Tourist [] touristsArray = new Tourist[100];

			for (int i = 0; i<touristsArray.length; i++) {
			touristsArray[i]= new Tourist();
			touristsArray[i].setName(df.getFirstName());
			touristsArray[i].setSurname(df.getLastName());
			touristsArray[i].setDateOfBirth(df.getBirthDate());
			touristsArray[i].setSex(Sex.Male);
			touristsArray[i].setCountry(df.getCity());
			lista.add(touristsArray[i]);
		}
		tDao.saveAll(lista);

		}
	
}
