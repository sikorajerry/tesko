package home.jsikora.repository;

import home.jsikora.dto.BezrealityDTO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sungsam on 3.7.17.
 */
public interface BezRealitkyRepository extends JpaRepository<BezrealityDTO,Long> {
    BezrealityDTO findByInzeratId(String inzeratId);
}
