package ru.zerat.pet_project.MeteoBase.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author Neil Alishev
 */
@Entity
@Data
@Table(name = "Meteodata")
@NoArgsConstructor
@AllArgsConstructor
public class Meteodata {
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

    @Column(name = "date_of_measurement")
    @NotNull
    private LocalDateTime date_of_measurement;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "sensor", referencedColumnName = "name")
    private Sensor sensor;

}
