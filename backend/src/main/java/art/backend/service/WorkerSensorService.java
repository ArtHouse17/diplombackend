package art.backend.service;

import art.backend.dto.SensorDTO;

public interface WorkerSensorService {
    void processWorker(SensorDTO data);
}
