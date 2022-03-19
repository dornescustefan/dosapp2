package com.project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project3.model.LapTop;

@Repository("laptopRepository")
public interface LapTopRepository extends JpaRepository<LapTop, String>{

}
