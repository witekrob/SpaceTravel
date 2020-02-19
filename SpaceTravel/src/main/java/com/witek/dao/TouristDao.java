package com.witek.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.witek.model.Tourist;
@Repository
public interface TouristDao extends JpaRepository<Tourist, Long> {

}
