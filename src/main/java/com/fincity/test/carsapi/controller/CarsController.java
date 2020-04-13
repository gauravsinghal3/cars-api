package com.fincity.test.carsapi.controller;

/*
 * Created by gusingha on 13-Apr-2020.
 */

import com.fincity.test.carsapi.component.CarModelAssembler;
import com.fincity.test.carsapi.exception.CarNotFoundException;
import com.fincity.test.carsapi.model.Car;
import com.fincity.test.carsapi.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.linkTo;

@RestController
public class CarsController {

    @Autowired
    private CarServiceImpl carService;

    @Autowired
    private CarModelAssembler carModelAssembler;

    @GetMapping("/cars")
    public List<EntityModel<Car>> retrieveAllCars() {

        return carService.findAllCars().stream()
                .map(carModelAssembler::toModel)
                .collect(Collectors.toList());

    }

    @GetMapping("/cars/{id}")
    public EntityModel<Car> retrieveCar(@Valid @PathVariable Long id) throws CarNotFoundException {
        return carModelAssembler.toModel(carService.findCar(id).get());
    }

    @GetMapping("/cars/search")
    public List<Car> retrieveCar(@RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "manufactureName", required = false) String manufactureName,
                                 @RequestParam(value = "model", required = false) String model,
                                 @RequestParam(value = "manufactureYear", required = false) String year,
                                 @RequestParam(value = "color", required = false) String color
                                 ) throws CarNotFoundException {
        return carService.search(name, manufactureName, model, year, color);
    }

    @PostMapping("/cars")
    public ResponseEntity<?> createCar(@Valid @RequestBody Car car){
        EntityModel<Car> entityModel = carModelAssembler.toModel(carService.save(car));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<?> updateCar(@Valid @PathVariable Long id, @Valid @RequestBody Car car) throws CarNotFoundException {
        EntityModel<Car> entityModel = carModelAssembler.toModel(carService.update(id,car));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id) throws CarNotFoundException{
        carService.deleteCarById(id);
        return ResponseEntity.noContent().build();
    }

}
