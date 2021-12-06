package com.fernandez.cars.controller;

import com.fernandez.cars.dto.ExampleDTO;
import com.fernandez.cars.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@Slf4j
@RequiredArgsConstructor
public class ExampleController {

    private final CarService carService;



    @GetMapping("/examples")
    public ResponseEntity<List<ExampleDTO>> findAllExamples(Pageable pageable) {
        log.info("CarsController[findAllCars]");
        List<ExampleDTO> exampleListDTO = new ArrayList<ExampleDTO>();
        Double dobule1 = 25.01;
        Double dobule2 = 4.00;
        Double dobule3 = 7.00;
        Double dobule4 = 18.01;
        Double dobule5 = 5.01;
        exampleListDTO.add(new ExampleDTO("opc1" , dobule1));
        exampleListDTO.add(new ExampleDTO("opc2" , dobule2));
        exampleListDTO.add(new ExampleDTO("opc3" , dobule3));
        exampleListDTO.add(new ExampleDTO("opc4" , dobule4));
        exampleListDTO.add(new ExampleDTO("opc5" , dobule5));
        return ResponseEntity.ok(exampleListDTO);
    }
}
