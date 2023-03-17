package ru.zerat.pet_project.MeteoBase.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Neil Alishev
 */
@Entity
@Data
@Table(name = "MeteoData")
@NoArgsConstructor
@AllArgsConstructor
public class MeteoData {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "temperature")
    @NotNull
    private Double temperature;

    @Column(name = "is_rainy")
    @NotNull
    private Boolean is_rainy;

}
