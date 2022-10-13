package liga.medical.medicalmonitoring.core.service.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import liga.medical.medicalmonitoring.core.service.RabbitDistributionByQueuesService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RabbitMessageListener {

    private final RabbitDistributionByQueuesService rabbitDistributionByQueuesService;

    @RabbitListener(queues = "common_monitoring")
    public void distributionFromQueueAndSendMessage(String message) throws JsonProcessingException {
        rabbitDistributionByQueuesService.distributionMessage(message);
    }
}
