package home.jsikora.repository;

import home.jsikora.dto.ProductCzIkeaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by sungsam on 23.5.17.
 */
@Repository
public interface CzIkeaRepository extends JpaRepository<ProductCzIkeaDTO,Long> {

    List<ProductCzIkeaDTO> findAllBySerialNumber(String serialNumber);






}
