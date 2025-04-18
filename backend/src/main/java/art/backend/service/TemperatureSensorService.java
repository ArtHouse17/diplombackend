package art.backend.service;

import art.backend.dto.SensorDTO;

public interface TemperatureSensorService {
    void processTemperature(SensorDTO data);
}
