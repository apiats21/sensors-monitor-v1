package com.supportportal.service;

import com.supportportal.domain.Sensor;

import java.util.List;

public interface SensorService {
    Sensor create(Sensor sensor);

    Sensor getById(Long id);

    List<Sensor> getSensors();

    Sensor update(Sensor sensor);

    void deleteById(Long id);

    boolean isExist(Long id);
}