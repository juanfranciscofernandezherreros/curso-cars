package com.fernandez.cars.dto;

import com.fernandez.cars.validation.FirstLetterUperCaseStr;
import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class CarDTO {

    private Long id;

    @NotBlank
    @FirstLetterUperCaseStr
    private String marca;

    @NotBlank
    @FirstLetterUperCaseStr
    private String modelo;

    private int totalPlaces;
}
