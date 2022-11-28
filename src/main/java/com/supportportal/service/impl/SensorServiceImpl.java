package com.supportportal.service.impl;

import com.supportportal.domain.Sensor;
import com.supportportal.repository.SensorRepository;
import com.supportportal.service.SensorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class SensorServiceImpl implements SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    @Override
    public Sensor create(Sensor sensor) {
        log.info("Saving new sensor: {}", sensor.getName());
        return sensorRepository.save(sensor);
    }

    @Override
    public Sensor getById(Long id) {
        Sensor sensor = sensorRepository.findById(id).orElse(null);
        log.info("IN SensorRepository: {}", sensor);
        return sensorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Sensor> getSensors() {
        return sensorRepository.findAll();
    }

    @Override
    public Sensor update(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    @Override
    public void deleteById(Long id) {
        sensorRepository.deleteById(id);
    }

    @Override
    public boolean isExist(Long id) {
        return sensorRepository.existsById(id);
    }
}

