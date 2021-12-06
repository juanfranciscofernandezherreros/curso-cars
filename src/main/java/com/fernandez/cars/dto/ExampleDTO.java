package com.fernandez.cars.dto;

import lombok.Data;

@Data
public class ExampleDTO {

    private String name;
    private double y;

    public ExampleDTO(String opc1, Double dobule1) {

        this.name = opc1;
        this.y = dobule1;
    }
}
