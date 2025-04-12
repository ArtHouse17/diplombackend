package art.emulator.controller;

import art.emulator.dto.SensorDTO;
import art.emulator.service.EmulationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SensorDataController {

    private final EmulationService emulationService;

    @GetMapping("/app")
    public List<SensorDTO> getSensorData() {
        List<SensorDTO> sensorDTOList = new ArrayList<>();
        sensorDTOList.add(emulationService.emulateTemperatureSensor());
        return sensorDTOList;
    }
}
