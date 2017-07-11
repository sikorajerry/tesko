package home.jsikora.repository;

import home.jsikora.dto.SrealityDTO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sungsam on 27.6.17.
 */
public interface SRealityRepository extends JpaRepository<SrealityDTO,Long> {
    SrealityDTO findByOdkaz(String odkaz);
}


