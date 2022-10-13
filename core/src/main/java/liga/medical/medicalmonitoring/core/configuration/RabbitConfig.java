package liga.medical.medicalmonitoring.core.configuration;

import liga.medical.medicalmonitoring.core.model.QueueNames;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${rabbit.host.name}")
    private String hostName;

    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory(hostName);
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public Queue queueMain() {
        return new Queue(QueueNames.MAIN_QUEUE.getQueueName());
    }

    @Bean
    public Queue queueDaily() {
        return new Queue(QueueNames.DAILY_QUEUE.getQueueName());
    }

    @Bean
    public Queue queueAlert() {
        return new Queue(QueueNames.ALERT_QUEUE.getQueueName());
    }

    @Bean
    public Queue queueError() {
        return new Queue(QueueNames.ERROR_QUEUE.getQueueName());
    }
}
