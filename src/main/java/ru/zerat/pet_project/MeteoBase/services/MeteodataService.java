package ru.zerat.pet_project.MeteoBase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zerat.pet_project.MeteoBase.models.Meteodata;
import ru.zerat.pet_project.MeteoBase.repositories.MeteodataRepository;

/**
 * @author Neil Alishev
 */
@Service
@Transactional(readOnly = true)
public class MeteodataService {

    private final MeteodataRepository meteoDataRepository;

    @Autowired
    public MeteodataService(MeteodataRepository meteoDataRepository) {
        this.meteoDataRepository = meteoDataRepository;
    }
    @Transactional
    public void save(Meteodata meteoData) {
        meteoDataRepository.save(meteoData);
    }

//    private MeteoData convertToMeteoData(MeteoDataDTO meteoDataDTO){
//        return modelMapper.map(meteoDataDTO, MeteoData.class);
//    }


}
