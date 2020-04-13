package com.fincity.test.carsapi.component;

import com.fincity.test.carsapi.controller.CarsController;
import com.fincity.test.carsapi.model.Car;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

/*
 * Created by gusingha on 13-Apr-2020.
 */
@Component
public class CarModelAssembler implements RepresentationModelAssembler<Car, EntityModel<Car>>{

    @Override
    public EntityModel<Car> toModel(Car car) {

        return new EntityModel<>(car,
                linkTo(methodOn(CarsController.class).retrieveCar(car.getId())).withSelfRel(),
                linkTo(methodOn(CarsController.class).retrieveAllCars()).withRel("all-cars"));
    }
}
