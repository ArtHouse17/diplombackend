package art.backend.service.impl;

import art.backend.dto.SensorDTO;
import art.backend.service.ChemicalSensorService;
import art.backend.service.DistributionService;
import art.backend.service.TemperatureSensorService;
import art.backend.service.WorkerSensorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
@AllArgsConstructor
@Service
public class DistributionServiceImpl implements DistributionService {

    private final ChemicalSensorService chemicalSensorService;
    private final TemperatureSensorService temperatureSensorService;
    private final WorkerSensorService workerSensorService;

    public void distributeSensors(SensorDTO data) {
        switch (data.getType()) {
            case "temp":
                temperatureSensorService.processTemperature(data);
                break;
            case "chem":
                chemicalSensorService.processChemical(data);
                break;
            case "pres":
                break;
            case "worker":
                workerSensorService.processWorker(data);
                break;
        }
    }
}
