package art.backend.service;

import art.backend.dto.SensorDTO;

public interface DistributionService {
    void distributeSensors(SensorDTO data);
}
