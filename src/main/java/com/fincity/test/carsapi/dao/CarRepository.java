package com.fincity.test.carsapi.dao;

/*
 * Created by gusingha on 13-Apr-2020.
 */

import com.fincity.test.carsapi.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {


}
