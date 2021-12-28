package com.fernandez.cars.service.impl;

import com.fernandez.cars.dto.CarDTO;
import com.fernandez.cars.exception.EntityNotFoundException;
import com.fernandez.cars.model.Car;
import com.fernandez.cars.repository.CarRepository;
import com.fernandez.cars.service.CarService;
import com.fernandez.cars.utils.ObjectMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class CarServiceImpl implements CarService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarServiceImpl.class);

    @Autowired
    private CarRepository carRepository;

    @Async
    @Override
    public CompletableFuture<List<Car>> saveCars(final InputStream inputStream) throws Exception {
        final long start = System.currentTimeMillis();

        List<Car> cars = parseCSVFile(inputStream);

        LOGGER.info("Saving a list of cars of size {} records", cars.size());

        cars = carRepository.saveAll(cars);

        LOGGER.info("Elapsed time: {}", (System.currentTimeMillis() - start));
        return CompletableFuture.completedFuture(cars);
    }

    private List<Car> parseCSVFile(final InputStream inputStream) throws Exception {
        final List<Car> cars=new ArrayList<>();
        try {
            try (final BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line=br.readLine()) != null) {
                    final String[] data=line.split(";");
                    final Car car=new Car();
                    car.setManufacturer(data[0]);
                    car.setModel(data[1]);
                    car.setType(data[2]);
                    cars.add(car);
                }
                return cars;
            }
        } catch(final IOException e) {
            LOGGER.error("Failed to parse CSV file {}", e);
            throw new Exception("Failed to parse CSV file {}", e);
        }
    }

    @Async
    @Override
    public CompletableFuture<List<Car>> getAllCars() {

        LOGGER.info("Request to get a list of cars");

        final List<Car> cars = carRepository.findAll();
        return CompletableFuture.completedFuture(cars);
    }

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
