package liga.medical.medicalmonitoring.core.repository;

import liga.medical.medicalmonitoring.core.model.Debug;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebugRepository extends CrudRepository<Debug, Long> {
}
