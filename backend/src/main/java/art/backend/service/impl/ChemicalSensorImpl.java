package art.backend.service.impl;

import art.backend.dto.SensorDTO;
import art.backend.service.ChemicalSensorService;
import art.backend.service.WorkerSensorService;
import org.springframework.stereotype.Service;

@Service
public class ChemicalSensorImpl implements ChemicalSensorService {
    @Override
    public void processChemical(SensorDTO data) {
        if (data.getTemperature() > ) {

        }
    }
}
