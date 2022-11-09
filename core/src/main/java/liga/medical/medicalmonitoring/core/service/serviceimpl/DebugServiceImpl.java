package liga.medical.medicalmonitoring.core.service.serviceimpl;

import liga.medical.medicalmonitoring.core.model.Debug;
import liga.medical.medicalmonitoring.core.repository.DebugRepository;
import liga.medical.medicalmonitoring.core.service.DebugService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DebugServiceImpl implements DebugService {

    private final DebugRepository debugRepository;

    @Override
    public Debug saveDebugInDB(Debug debug) {
        return debugRepository.save(debug);
    }
}
