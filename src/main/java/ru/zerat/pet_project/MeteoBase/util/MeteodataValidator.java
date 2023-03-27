package ru.zerat.pet_project.MeteoBase.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.zerat.pet_project.MeteoBase.models.Meteodata;
import ru.zerat.pet_project.MeteoBase.models.Sensor;
import ru.zerat.pet_project.MeteoBase.services.MeteodataService;
import ru.zerat.pet_project.MeteoBase.services.SensorService;

@Component
public class MeteodataValidator implements Validator{

    private final SensorService sensorService;

    @Autowired
    public MeteodataValidator(SensorService sensorService){
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> aClass){
        return Meteodata.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors){
        Meteodata meteodata = (Meteodata) o;

        if (meteodata.getSensor() == null) {
            return;
        }

        if (sensorService.findByName(meteodata.getSensor().getName()).isEmpty())
            errors.rejectValue("sensor", "Сенсор, отправивший информацю, с такими именем не существует!!");
    }
}
