package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;
import java.util.List;
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
@Query("select c from Country c where c.name like %?1%")
public List<Country> findCountryNameContain(String str);
}
