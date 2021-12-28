package com.fernandez.cars.service;

import com.fernandez.cars.dto.*;
import com.fernandez.cars.model.Car;
import org.springframework.data.domain.*;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface CarService {

    CarDTO createOrUpdateCar(CarDTO carDTO);

    Page<CarDTO> findAllCars(Pageable pageable);

    CarDTO findCarById(Long carId);

    void deleteCarById(Long carId);

    CompletableFuture<List<Car>> saveCars(final InputStream inputStream) throws Exception;

    CompletableFuture<List<Car>> getAllCars();
}
