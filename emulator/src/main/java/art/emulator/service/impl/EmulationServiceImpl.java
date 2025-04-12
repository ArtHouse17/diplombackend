package art.emulator.service.impl;

import art.emulator.dto.SensorDTO;
import art.emulator.service.EmulationService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;
@Service
public class EmulationServiceImpl implements EmulationService {
    @Override
    public SensorDTO emulateTemperatureSensor() {
        SensorDTO sensorDTO = new SensorDTO();
        sensorDTO.setId("temp1");
        sensorDTO.setType("temp");
        sensorDTO.setUnit("Celsius");
        sensorDTO.setTemperature(ThreadLocalRandom.current().nextDouble(10,40));
        sensorDTO.setStatus("OK");
        return sensorDTO;
    }
    public SensorDTO emulateChemicalSensor() {
        SensorDTO sensorDTO = new SensorDTO();
        sensorDTO.setId("temp1");
        sensorDTO.setType("temp");
        sensorDTO.setUnit("Celsius");
        sensorDTO.setTemperature(ThreadLocalRandom.current().nextDouble(10,40));
        sensorDTO.setStatus("OK");
        return sensorDTO;
    }
    public SensorDTO emulatePressureSensor() {
        SensorDTO sensorDTO = new SensorDTO();
        sensorDTO.setId("temp1");
        sensorDTO.setType("temp");
        sensorDTO.setUnit("Celsius");
        sensorDTO.setTemperature(ThreadLocalRandom.current().nextDouble(10,40));
        sensorDTO.setStatus("OK");
        return sensorDTO;
    }
}
