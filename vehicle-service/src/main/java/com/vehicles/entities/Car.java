package com.vehicles.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car extends Vehicle {

    private String type;
    private Integer numberOfDoors;
    private Integer passengerCapacity;
    private Integer trunkCapacityLiters;

    public Car() {}

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Integer getNumberOfDoors() { return numberOfDoors; }
    public void setNumberOfDoors(Integer numberOfDoors) { this.numberOfDoors = numberOfDoors; }

    public Integer getPassengerCapacity() { return passengerCapacity; }
    public void setPassengerCapacity(Integer passengerCapacity) { this.passengerCapacity = passengerCapacity; }

    public Integer getTrunkCapacityLiters() { return trunkCapacityLiters; }
    public void setTrunkCapacityLiters(Integer trunkCapacityLiters) { this.trunkCapacityLiters = trunkCapacityLiters; }
}
