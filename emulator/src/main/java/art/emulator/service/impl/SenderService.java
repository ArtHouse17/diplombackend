package art.emulator.service.impl;

import art.backend.dto.SensorDTO;
import art.emulator.kafka.KafkaSender;
import art.emulator.service.EmulationService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SenderService {
    private final EmulationService emulationService;
    private KafkaSender kafkaSender;

    @Scheduled(fixedRate = 5000)
    public void send() {
        List<SensorDTO> dtos = new ArrayList<>();
        var dto1 = emulationService.emulateTemperatureSensor();
        dtos.add(dto1);
        var dto2 = emulationService.emulateTemperatureSensor();
        dtos.add(dto2);
        for (SensorDTO sensorDTO : dtos) {
            kafkaSender.send("topic.text.sensor", sensorDTO);
        }
    }
}
