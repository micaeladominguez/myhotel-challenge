package com.vehicles.repositories;

import com.vehicles.entities.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
    List<Maintenance> findByVehicleId(Long vehicleId);
}
