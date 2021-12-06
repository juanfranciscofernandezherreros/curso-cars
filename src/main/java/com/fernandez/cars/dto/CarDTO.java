package com.fernandez.cars.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class CarDTO {

    private Long id;

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    private int totalPlaces;
}
