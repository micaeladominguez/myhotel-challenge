package com.vehicles.controller;

import com.vehicles.entities.Vehicle;
import com.vehicles.entities.Maintenance;
import com.vehicles.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        Vehicle createdVehicle = vehicleService.createVehicle(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVehicle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicleDetails) {
        Vehicle updatedVehicle = vehicleService.updateVehicle(id, vehicleDetails);
        return ResponseEntity.ok(updatedVehicle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/maintenances")
    public ResponseEntity<List<Maintenance>> getMaintenancesByVehicle(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getMaintenancesByVehicleId(id));
    }

    @PostMapping("/{id}/maintenances")
    public ResponseEntity<Maintenance> addMaintenance(@PathVariable Long id, @RequestBody Maintenance maintenance) {
        Maintenance createdMaintenance = vehicleService.addMaintenanceToVehicle(id, maintenance);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMaintenance);
    }
}
