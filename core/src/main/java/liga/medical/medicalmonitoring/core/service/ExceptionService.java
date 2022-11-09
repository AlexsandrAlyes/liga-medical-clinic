package liga.medical.medicalmonitoring.core.service;

import liga.medical.medicalmonitoring.core.model.Exception;

public interface ExceptionService {

    Exception saveExceptionInDB(Exception exception);
}
