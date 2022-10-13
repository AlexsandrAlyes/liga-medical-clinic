package liga.medical.medicalmonitoring.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface RabbitDistributionByQueuesService {

    void distributionMessage(String message) throws JsonProcessingException;
}
