package woodspring.springbase.dto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import woodspring.springbase.entity.NumberH2;

@Repository
public interface NumberRepo  extends CrudRepository<NumberH2, Long>{

}
