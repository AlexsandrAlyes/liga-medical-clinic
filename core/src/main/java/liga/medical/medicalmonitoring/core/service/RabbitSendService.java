package liga.medical.medicalmonitoring.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import liga.medical.medicalmonitoring.core.model.MessageDTO;

public interface RabbitSendService {
    void sendMessage(MessageDTO message, String queue) throws JsonProcessingException;
}
