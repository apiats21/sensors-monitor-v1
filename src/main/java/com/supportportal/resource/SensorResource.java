package com.supportportal.resource;

import com.supportportal.domain.Sensor;
import com.supportportal.domain.User;
import com.supportportal.service.SensorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/sensor")
@RequiredArgsConstructor
@Slf4j
public class SensorResource {
    private final SensorService sensorService;

    @GetMapping(value = "{id}")
    public ResponseEntity<Sensor> getById(@PathVariable(name = "id") Long id) {
        Sensor sensor = sensorService.getById(id);
        log.info("In getById ee: {}", id);

        if (sensor == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(sensor, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Sensor>> getAllSensors() {
        List<Sensor> users = sensorService.getSensors();
        return new ResponseEntity<>(users, OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Sensor> save(@RequestBody @Valid Sensor sensor) {
        Sensor savedSensor = sensorService.create(sensor);
        return new ResponseEntity<>(savedSensor, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<Sensor> update(@RequestBody @Valid Sensor sensor) {
        if (!sensorService.isExist(sensor.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Sensor updatedSensor = sensorService.update(sensor);
        return new ResponseEntity<>(updatedSensor, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) {
        if (!sensorService.isExist(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        sensorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

