package ru.zerat.pet_project.MeteoBase.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.zerat.pet_project.MeteoBase.dto.MeteodataDTO;
import ru.zerat.pet_project.MeteoBase.models.Meteodata;
import ru.zerat.pet_project.MeteoBase.services.MeteodataService;

import javax.validation.Valid;

/**
 * @author Neil Alishev
 */
@RestController // @Controller + @ResponseBody над каждым методом
@RequestMapping()
public class MeteodataController {

    private final MeteodataService meteodataService;
    private final ModelMapper modelMapper;

    @Autowired
    public MeteodataController(MeteodataService meteodataService, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.meteodataService = meteodataService;
    }

    @PostMapping("/api/save")
    public void saveMeteoData(@RequestBody @Valid MeteodataDTO meteoDataDTO, BindingResult bindingResult) {
        meteodataService.save(convertToMeteoData(meteoDataDTO)); // Jackson конвертирует в JSON
    }

    private Meteodata convertToMeteoData(MeteodataDTO meteoDataDTO){
        return modelMapper.map(meteoDataDTO, Meteodata.class);
    }

}
