package ru.zerat.pet_project.MeteoBase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.zerat.pet_project.MeteoBase.models.Meteodata;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
public class MeteodatasResponse {

    private final List<MeteodataDTO> AllMeteodata;

}
