package liga.medical.medicalmonitoring.core.service.serviceimpl;

import liga.medical.medicalmonitoring.core.model.Exception;
import liga.medical.medicalmonitoring.core.repository.ExceptionRepository;
import liga.medical.medicalmonitoring.core.service.ExceptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExceptionServiceImpl implements ExceptionService {

    private final ExceptionRepository exceptionRepository;

    @Override
    public Exception saveExceptionInDB(Exception exception) {
        return exceptionRepository.save(exception);
    }
}
