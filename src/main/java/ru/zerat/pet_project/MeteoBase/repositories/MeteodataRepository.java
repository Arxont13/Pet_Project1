package ru.zerat.pet_project.MeteoBase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zerat.pet_project.MeteoBase.models.Meteodata;

/**
 * @author Neil Alishev
 */
@Repository
public interface MeteodataRepository extends JpaRepository<Meteodata, Integer> {

}
