package liga.medical.medicalmonitoring.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.medicalmonitoring.core.model.MessageDTO;
import liga.medical.medicalmonitoring.core.model.QueueNames;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RabbitDistributionByQueuesServiceImpl implements RabbitDistributionByQueuesService {

    private final ObjectMapper mapper;

    private final RabbitSendService rabbitSendService;

    @Override
    public void distributionMessage(String message) throws JsonProcessingException {
        MessageDTO messageDTO = mapper.readValue(message, MessageDTO.class);
        switch (messageDTO.getStatus()) {
            case DAILY:
                rabbitSendService.sendMessage(messageDTO, QueueNames.DAILY_QUEUE.getQueueName());
                break;
            case ALERT:
                rabbitSendService.sendMessage(messageDTO, QueueNames.ALERT_QUEUE.getQueueName());
                break;
            case ERROR:
                rabbitSendService.sendMessage(messageDTO, QueueNames.ERROR_QUEUE.getQueueName());
                break;
            default:
                try {
                    throw new Exception("Не известный статус сообщения,в очередь не распределен");
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }
}
