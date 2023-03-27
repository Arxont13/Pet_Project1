package ru.zerat.pet_project.MeteoBase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zerat.pet_project.MeteoBase.models.Meteodata;
import ru.zerat.pet_project.MeteoBase.repositories.MeteodataRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Neil Alishev
 */
@Service
@Transactional(readOnly = true)
public class MeteodataService {

    private final MeteodataRepository meteoDataRepository;
    private final SensorService sensorService;

    @Autowired
    public MeteodataService(MeteodataRepository meteoDataRepository,
                            SensorService sensorService) {
        this.meteoDataRepository = meteoDataRepository;
        this.sensorService = sensorService;
    }

    public List<Meteodata> findAll(){
        return meteoDataRepository.findAll();
    }

    @Transactional
    public void saveMeteodata(Meteodata meteoData) {
        enrichMeteodata(meteoData);
        meteoDataRepository.save(meteoData);
    }

    public void enrichMeteodata(Meteodata meteodata){
        meteodata.setSensor(sensorService.findByName(meteodata.getSensor().getName()).get());

        meteodata.setDate_of_measurement(LocalDateTime.now());
    }
}
