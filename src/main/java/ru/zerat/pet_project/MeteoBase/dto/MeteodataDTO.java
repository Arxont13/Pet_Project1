package ru.zerat.pet_project.MeteoBase.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class MeteodataDTO {

    @Column(name = "temperature")
    @NotNull
    private Double temperature;

    @Column(name = "is_rainy")
    @NotNull
    private Boolean is_rainy;

}
