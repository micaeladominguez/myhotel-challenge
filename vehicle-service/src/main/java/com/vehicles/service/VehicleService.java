package com.vehicles.service;

import com.vehicles.entities.*;
import com.vehicles.repositories.VehicleRepository;
import com.vehicles.repositories.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found: " + vehicleId));
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicle(Long vehicleId, Vehicle vehicleDetails) {
        Vehicle vehicle = getVehicleById(vehicleId);
        vehicle.setBrand(vehicleDetails.getBrand());
        vehicle.setModel(vehicleDetails.getModel());
        vehicle.setFabricationDate(vehicleDetails.getFabricationDate());
        vehicle.setNumberOfKilometers(vehicleDetails.getNumberOfKilometers());

        if(vehicle instanceof Car car && vehicleDetails instanceof Car detailsCar) {
            car.setType(detailsCar.getType());
            car.setNumberOfDoors(detailsCar.getNumberOfDoors());
            car.setPassengerCapacity(detailsCar.getPassengerCapacity());
            car.setTrunkCapacityLiters(detailsCar.getTrunkCapacityLiters());
        } else if(vehicle instanceof Truck truck && vehicleDetails instanceof Truck detailsTruck) {
            truck.setCargoCapacity(detailsTruck.getCargoCapacity());
            truck.setNumberOfAxles(detailsTruck.getNumberOfAxles());
        }

        return vehicleRepository.save(vehicle);
    }


    public void deleteVehicle(Long vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }

    public List<Maintenance> getMaintenancesByVehicleId(Long vehicleId) {
        return maintenanceRepository.findByVehicleId(vehicleId);
    }

    public Maintenance addMaintenanceToVehicle(Long vehicleId, Maintenance maintenance) {
        Vehicle vehicle = getVehicleById(vehicleId);
        maintenance.setVehicle(vehicle);
        return maintenanceRepository.save(maintenance);
    }
}
