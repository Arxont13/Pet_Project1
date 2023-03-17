package ru.zerat.pet_project.MeteoBase.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class MeteoDataDTO {

    @Column(name = "temperature")
    @NotNull
    private Double temperature;

    @Column(name = "is_rainy")
    @NotNull
    private Boolean is_rainy;

}
