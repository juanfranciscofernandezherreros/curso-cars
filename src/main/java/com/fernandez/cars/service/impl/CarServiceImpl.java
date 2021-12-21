package com.fernandez.cars.service.impl;

import com.fernandez.cars.dto.*;
import com.fernandez.cars.exception.*;
import com.fernandez.cars.model.*;
import com.fernandez.cars.repository.*;
import com.fernandez.cars.service.*;
import com.fernandez.cars.utils.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    
    private final CarRepository carRepository;

    @Override
    public Page<CarDTO> findAllCars(Pageable pageable) {
        log.info("CarServiceImpl[findAllCars]");
        return ObjectMapperUtils.mapEntityPageIntoDtoPage(carRepository.findAll(pageable), CarDTO.class);
    }

    @Override
    public CarDTO findCarById(Long carId) {
        log.info("CarServiceImpl[findCarById]", carId);
        Optional<Car> optionalCar = carRepository.findById(carId);
        if(!optionalCar.isPresent()){
            throw new EntityNotFoundException(Car.class, "id", carId.toString());
        }
        return ObjectMapperUtils.map(optionalCar,CarDTO.class);
    }

    @Override
    public CarDTO createOrUpdateCar(CarDTO carDTO) {
        log.info("CarServiceImpl[createOrUpdateCar]" , carDTO);
        return ObjectMapperUtils.map(carRepository.save(ObjectMapperUtils.map(carDTO,Car.class)),CarDTO.class);
    }

    @Override
    public void deleteCarById(Long carId) {
        log.info("CarServiceImpl[deleteCarById]", carId);
        Optional<Car> optionalCar = carRepository.findById(carId);
        if(!optionalCar.isPresent()){
            throw new EntityNotFoundException(Car.class, "id", carId.toString());
        }
        carRepository.deleteById(carId);
    }
}
