package art.backend.service.impl;

import art.backend.dao.SensorDAO;
import art.backend.dao.SensorReadingDAO;
import art.backend.dto.SensorDTO;
import art.backend.entity.SensorReading;
import art.backend.service.ChemicalSensorService;
import art.backend.service.DistributionService;
import art.backend.service.TemperatureSensorService;
import art.backend.service.WorkerSensorService;
import art.backend.service.impl.enums.EventTypes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class DistributionServiceImpl implements DistributionService {

    private final ChemicalSensorService chemicalSensorService;
    private final TemperatureSensorService temperatureSensorService;
    private final WorkerSensorService workerSensorService;
    private final LogsFormerServiceImpl logsFormerServiceImpl;
    private final CommandFormerServiceImpl commandFormerServiceImpl;
    private final SensorReadingDAO sensorReadingDAO;
    private final SensorDAO sensorDAO;

    public void distributeSensors(SensorDTO data) {
        SensorReading sensorReading;
        switch (data.getType()) {
            case "temp":
                temperatureSensorService.processTemperature(data);
                var findSensorbyID = sensorDAO.findSensorBySensortype(data.getId());
                 sensorReading = SensorReading.builder()
                        .readingvalue(data.getTemperature())
                        .timestamp(LocalDateTime.now())
                        .unit(data.getUnit())
                        .sensor(findSensorbyID)
                        .build();
                sensorReadingDAO.save(sensorReading);
                break;
            case "chem":
                findSensorbyID = sensorDAO.findSensorBySensortype(data.getId());
                sensorReading = SensorReading.builder()
                        .readingvalue(data.getConcentration())
                        .timestamp(LocalDateTime.now())
                        .unit(data.getUnit())
                        .sensor(findSensorbyID)
                        .build();
                sensorReadingDAO.save(sensorReading);
                try {
                    chemicalSensorService.processChemical(data);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "pres":
                break;
            case "worker":
                //workerSensorService.processWorker(data);
                break;
        }

    }
}
