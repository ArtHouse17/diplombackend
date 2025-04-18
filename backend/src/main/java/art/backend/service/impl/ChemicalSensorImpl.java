package art.backend.service.impl;

import art.backend.dto.SensorDTO;
import art.backend.service.ChemicalSensorService;
import art.backend.service.WorkerSensorService;
import art.backend.service.impl.enums.Chemicalparam;
import org.springframework.stereotype.Service;

@Service
public class ChemicalSensorImpl implements ChemicalSensorService {
    Chemicalparam chemicalparam = Chemicalparam.CHEMICALPARAM;

    @Override
    public void processChemical(SensorDTO data) {
        if (data.getTemperature() > chemicalparam.getParam()) {

        }
    }
}
