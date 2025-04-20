package art.backend.service.impl;

import art.backend.dao.LogDAO;
import art.backend.dto.SensorDTO;
import art.backend.entity.Log;
import art.backend.entity.Sensor;
import art.backend.service.impl.enums.EventTypes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
@AllArgsConstructor
public class LogsFormerServiceImpl {

    private final LogDAO logDAO;

    public void processLog(SensorDTO data, EventTypes type) {
        StringBuilder message = new StringBuilder();
        String event;
        switch (type) {
            case Fire:
                event = "Пожар";
                message.append("Событие: ").append(event).append(" Система счисления:").append(data.getUnit()).append(" Значение:").append(data.getTemperature());
                break;
            case Chemical:
                event = "Химическая угроза";
                message.append("Событие: ").append(event).append(" Система счисления:").append(data.getUnit()).append(" Значение:").append(data.getConcentration());
                break;
            default:
                event = "none";
                message.append("Событие: ").append(event).append(" Тип датчика:").append(data.getType());
        }
        saveLogs(data, message.toString(),event);
    }

    private void saveLogs(SensorDTO data, String message, String event) {
        var log = Log.builder()
                .eventtype(event)
                .description(message)
                .timestamp(LocalDateTime.now())
                .build();
        logDAO.save(log);
    }
}
