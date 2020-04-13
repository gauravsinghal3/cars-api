package com.fincity.test.carsapi.dao;

/*
 * Created by gusingha on 13-Apr-2020.
 */

import com.fincity.test.carsapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
