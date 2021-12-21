package com.fernandez.cars.service;

import com.fernandez.cars.dto.*;
import org.springframework.data.domain.*;

public interface CarService {

    CarDTO createOrUpdateCar(CarDTO carDTO);

    Page<CarDTO> findAllCars(Pageable pageable);

    CarDTO findCarById(Long carId);

    void deleteCarById(Long carId);
}
