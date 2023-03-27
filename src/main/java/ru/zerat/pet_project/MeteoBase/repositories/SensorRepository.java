package ru.zerat.pet_project.MeteoBase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zerat.pet_project.MeteoBase.models.Meteodata;
import ru.zerat.pet_project.MeteoBase.models.Sensor;

import java.util.Optional;

/**
 * @author Neil Alishev
 */
@Repository
public interface SensorRepository extends JpaRepository<Sensor, String> {
    Optional<Sensor> findByName(String name);
}
