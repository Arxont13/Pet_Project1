package ru.zerat.pet_project.MeteoBase.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zerat.pet_project.MeteoBase.dto.MeteoDataDTO;
import ru.zerat.pet_project.MeteoBase.models.MeteoData;
import ru.zerat.pet_project.MeteoBase.repositories.MeteoDataRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Neil Alishev
 */
@Service
@Transactional(readOnly = true)
public class MeteoDataService {

    private final MeteoDataRepository meteoDataRepository;

    @Autowired
    public MeteoDataService(MeteoDataRepository meteoDataRepository) {
        this.meteoDataRepository = meteoDataRepository;
    }
    @Transactional
    public void save(MeteoData meteoData) {
        meteoDataRepository.save(meteoData);
    }

//    private MeteoData convertToMeteoData(MeteoDataDTO meteoDataDTO){
//        return modelMapper.map(meteoDataDTO, MeteoData.class);
//    }


}
