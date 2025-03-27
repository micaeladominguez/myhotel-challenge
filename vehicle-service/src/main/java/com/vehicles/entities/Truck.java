package com.vehicles.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "trucks")
public class Truck extends Vehicle {

    @Column(name = "cargo_capacity")
    private Double cargoCapacity;

    private Integer numberOfAxles;

    public Truck() {}

    public Double getCargoCapacity() { return cargoCapacity; }
    public void setCargoCapacity(Double cargoCapacity) { this.cargoCapacity = cargoCapacity; }

    public Integer getNumberOfAxles() { return numberOfAxles; }
    public void setNumberOfAxles(Integer numberOfAxles) { this.numberOfAxles = numberOfAxles; }
}
