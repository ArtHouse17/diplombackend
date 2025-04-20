package art.backend.kafka;

import art.backend.dto.CommandDTO;
import art.backend.dto.SensorDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSender {

    private KafkaTemplate<String, CommandDTO> kafkaTemplate;

    public KafkaSender(KafkaTemplate<String, CommandDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, CommandDTO message) {
        kafkaTemplate.send(topic, message);
    }

}
