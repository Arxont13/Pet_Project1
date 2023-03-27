package ru.zerat.pet_project.MeteoBase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zerat.pet_project.MeteoBase.models.Meteodata;
import ru.zerat.pet_project.MeteoBase.models.Sensor;
import ru.zerat.pet_project.MeteoBase.repositories.MeteodataRepository;
import ru.zerat.pet_project.MeteoBase.repositories.SensorRepository;

import java.util.Optional;

/**
 * @author Neil Alishev
 */
@Service
@Transactional(readOnly = true)
public class SensorService {

    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }


    public Optional<Sensor> findByName(String name) {
        return sensorRepository.findByName(name);
    }

    @Transactional
    public void register(Sensor sensor) {
        sensorRepository.save(sensor);
    }

}
