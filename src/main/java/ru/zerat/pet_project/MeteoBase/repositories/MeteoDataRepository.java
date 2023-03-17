package ru.zerat.pet_project.MeteoBase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zerat.pet_project.MeteoBase.models.MeteoData;

/**
 * @author Neil Alishev
 */
@Repository
public interface MeteoDataRepository extends JpaRepository<MeteoData, Integer> {

}
