package liga.medical.medicalmonitoring.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.medicalmonitoring.core.model.MessageDTO;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RabbitSendServiceImpl implements RabbitSendService {

    private final AmqpTemplate amqpTemplate;

    private final ObjectMapper mapper;

    @Override
    public void sendMessage(MessageDTO message, String queue) throws JsonProcessingException {
        String messageToString = mapper.writeValueAsString(message);
        amqpTemplate.convertAndSend(queue, messageToString);
    }
}
