package art.backend.kafka;

import art.backend.dto.SensorDTO;
import art.backend.service.DistributionService;
import art.backend.websocket.WebSocketServer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@AllArgsConstructor
public class KafkaListener {

    private DistributionService distributionService;
    private WebSocketServer webSocketServer;

    @org.springframework.kafka.annotation.KafkaListener(topics = "topic.text.sensor", groupId = "group1", containerFactory = "userKafkaListenerContainerFactory")
    public void listener(SensorDTO data) throws IOException {
        System.out.println(data);
        distributionService.distributeSensors(data);
        if (webSocketServer != null) {
            webSocketServer.addSensor(data);
        } else {
            throw new IllegalStateException("WebSocketServer is not initialized");
        }
    }
}
