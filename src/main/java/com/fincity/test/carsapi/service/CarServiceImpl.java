package com.fincity.test.carsapi.service;

/*
 * Created by gusingha on 13-Apr-2020.
 */

import com.fincity.test.carsapi.dao.CarRepository;
import com.fincity.test.carsapi.exception.CarNotFoundException;
import com.fincity.test.carsapi.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> findAllCars(){
        return carRepository.findAll();
    }

    public Optional<Car> findCar(Long id) throws CarNotFoundException {
        Optional<Car> car =  carRepository.findById(id);
        if(!car.isPresent())
            throw new CarNotFoundException("Car not found for Id: " + id);
        return car;
    }

    public Car save(Car car){
        Car c =  carRepository.save(car);
        return c;
    }

    public void deleteCarById(Long id) throws CarNotFoundException {
        Optional<Car> car =  carRepository.findById(id);
        if(!car.isPresent())
            throw new CarNotFoundException("Car not found for Id: " + id);
        carRepository.deleteById(id);
    }

    public List<Car> search(String name,String manufactureName,String model,String manufactureYear,String color){

        Car car = new Car(name, manufactureName, model, manufactureYear, color);
        List<Car> carList = carRepository.findAll(Example.of(car));

        if(carList.isEmpty())
            throw new CarNotFoundException("Car not found with the parameters provided: " + car.toString());

        return carList;
    }

    public Car update(Long id, Car car) {
        Optional<Car> carObj =  carRepository.findById(id);
        if(!carObj.isPresent())
            throw new CarNotFoundException("Car not found for Id: " + id);

        carObj.get().setName(car.getName()!=null?car.getName():carObj.get().getName());
        carObj.get().setManufactureName(car.getManufactureName()!=null?car.getManufactureName():carObj.get().getManufactureName());
        carObj.get().setModel(car.getModel()!=null?car.getModel():carObj.get().getModel());
        carObj.get().setManufactureYear(car.getManufactureYear()!=null?car.getManufactureYear():carObj.get().getManufactureYear());
        carObj.get().setColor(car.getColor()!=null?car.getColor():carObj.get().getColor());

        Car c =  carRepository.save(carObj.get());
        return c;

    }
}
