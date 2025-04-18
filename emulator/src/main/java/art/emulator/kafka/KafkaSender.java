package art.emulator.kafka;

import art.backend.dto.SensorDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSender {

    private KafkaTemplate<String, SensorDTO> kafkaTemplate;

    public KafkaSender(KafkaTemplate<String, SensorDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, SensorDTO message) {
        kafkaTemplate.send(topic, message);
    }

}
