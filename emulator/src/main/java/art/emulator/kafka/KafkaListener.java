package art.emulator.kafka;

import art.backend.dto.CommandDTO;
import art.backend.dto.SensorDTO;
import art.backend.service.DistributionService;
import art.backend.websocket.WebSocketServer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@AllArgsConstructor
public class KafkaListener {


    @org.springframework.kafka.annotation.KafkaListener(topics = "topic.text.command", groupId = "group1", containerFactory = "userKafkaListenerContainerFactory")
    public void listener(CommandDTO data) throws IOException {
        System.out.println(data);
    }
}
