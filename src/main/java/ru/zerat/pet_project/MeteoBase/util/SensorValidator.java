package ru.zerat.pet_project.MeteoBase.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.zerat.pet_project.MeteoBase.models.Sensor;
import ru.zerat.pet_project.MeteoBase.services.SensorService;

import javax.validation.Valid;

@Component
public class SensorValidator implements Validator {

    private final SensorService sensorService;

    @Autowired
    public SensorValidator(SensorService sensorService){
       this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> aClass){
        return Sensor.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors){
        Sensor sensor = (Sensor) o;

        if (sensorService.findByName(sensor.getName()).isPresent())
            errors.rejectValue("name", "Уже есть сенсор с таким названием!");
    }
}
