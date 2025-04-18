package art.backend.websocket;

import art.backend.dto.SensorDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
public class WebSocketServer extends TextWebSocketHandler {
    private static final Set<WebSocketSession> sessions = new CopyOnWriteArraySet<>();
    private List<SensorDTO> sensors = new ArrayList<>();

    public void addSensor(SensorDTO sensor) throws IOException {
        sensors.add(sensor);
        sendSensorDataToAll();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("Connected");
        sessions.add(session);
        sendSensorData(session);
    }

    private void sendSensorDataToAll() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        for (WebSocketSession session : sessions) {
            for (SensorDTO sensor : sensors) {
                if ("OK".equals(sensor.getStatus())) {
                    String message = objectMapper.writeValueAsString(sensor);
                    session.sendMessage(new TextMessage(message));
                    System.out.println("Sent message: " + message);
                }
            }
        }
    }

    private void sendSensorData(WebSocketSession session) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        for (SensorDTO sensor : sensors) {
            if ("OK".equals(sensor.getStatus())) {
                String message = objectMapper.writeValueAsString(sensor);
                session.sendMessage(new TextMessage(message));
                System.out.println("Sent message: " + message);
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessions.remove(session);
    }
}