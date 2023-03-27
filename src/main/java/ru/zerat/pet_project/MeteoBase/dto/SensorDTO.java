package ru.zerat.pet_project.MeteoBase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Table(name = "Sensor")
@NoArgsConstructor
@AllArgsConstructor
public class SensorDTO implements Serializable{

    @Column(name = "name")
    @NotEmpty(message = "Name should not be empty!")
    private String name;

}
