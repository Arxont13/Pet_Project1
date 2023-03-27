package ru.zerat.pet_project.MeteoBase.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.zerat.pet_project.MeteoBase.dto.MeteodataDTO;
import ru.zerat.pet_project.MeteoBase.dto.MeteodatasResponse;
import ru.zerat.pet_project.MeteoBase.models.Meteodata;
import ru.zerat.pet_project.MeteoBase.services.MeteodataService;
import ru.zerat.pet_project.MeteoBase.util.MeteodataErrorResponse;
import ru.zerat.pet_project.MeteoBase.util.MeteodataException;
import ru.zerat.pet_project.MeteoBase.util.MeteodataValidator;

import javax.validation.Valid;

import java.util.stream.Collectors;

import static ru.zerat.pet_project.MeteoBase.util.ErrorsUtil.returnErrorsToClient;

/**
 * @author Neil Alishev
 */
@RestController // @Controller + @ResponseBody над каждым методом
@RequestMapping()
public class MeteodataController {

    private final MeteodataService meteodataService;
    private final ModelMapper modelMapper;
    private final MeteodataValidator meteodataValidator;

    @Autowired
    public MeteodataController(MeteodataService meteodataService,
                               ModelMapper modelMapper,
                               MeteodataValidator meteodataValidator
                               ) {
        this.modelMapper = modelMapper;
        this.meteodataService = meteodataService;
        this.meteodataValidator = meteodataValidator;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid MeteodataDTO meteoDataDTO, BindingResult bindingResult) {

        Meteodata meteodataToAdd = convertToMeteodata(meteoDataDTO);

        meteodataValidator.validate(meteodataToAdd, bindingResult);

        if (bindingResult.hasErrors())
            returnErrorsToClient(bindingResult);

        meteodataService.saveMeteodata(convertToMeteodata(meteoDataDTO)); // Jackson конвертирует в JSON
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping()
    public MeteodatasResponse getAllMeteodata(){
        return new MeteodatasResponse(meteodataService.findAll().stream().map(this:: convertToMeteodataDTO)
            .collect(Collectors.toList()));
    }

    private Meteodata convertToMeteodata(MeteodataDTO meteoDataDTO){
        return modelMapper.map(meteoDataDTO, Meteodata.class);
    }

    private MeteodataDTO convertToMeteodataDTO(Meteodata meteoData){
        return modelMapper.map(meteoData, MeteodataDTO.class);
    }
    @ExceptionHandler
    public ResponseEntity<MeteodataErrorResponse> handleException(MeteodataException e){

        MeteodataErrorResponse response = new MeteodataErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
