package ru.zerat.pet_project.MeteoBase.controllers;

import org.dom4j.rule.Mode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.zerat.pet_project.MeteoBase.dto.MeteoDataDTO;
import ru.zerat.pet_project.MeteoBase.models.MeteoData;
import ru.zerat.pet_project.MeteoBase.services.MeteoDataService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Neil Alishev
 */
@RestController // @Controller + @ResponseBody над каждым методом
@RequestMapping()
public class MeteoDataController {

    private final MeteoDataService meteoDataService;
    private final ModelMapper modelMapper;

    @Autowired
    public MeteoDataController(MeteoDataService meteoDataService, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.meteoDataService = meteoDataService;
    }

    @PostMapping("/api/save")
    public void saveMeteoData(@RequestBody @Valid MeteoDataDTO meteoDataDTO, BindingResult bindingResult) {
        meteoDataService.save(convertToMeteoData(meteoDataDTO)); // Jackson конвертирует в JSON
    }

    private MeteoData convertToMeteoData(MeteoDataDTO meteoDataDTO){
        return modelMapper.map(meteoDataDTO, MeteoData.class);
    }

}
