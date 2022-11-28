package com.supportportal.repository;

import com.supportportal.domain.Sensor;
import com.supportportal.domain.Type;
import com.supportportal.domain.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    Sensor findAllByNameContainingOrModelContainingOrTypeContainingOrRangeFromContainingOrRangeToContainingOrUnitContainingOrLocationContainingOrDescriptionContaining
            (String name, String model, Type type, Long rangeFrom, Long rangeTo, Unit unit, String location, String description);

}