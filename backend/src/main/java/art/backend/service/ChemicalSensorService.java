package art.backend.service;

import art.backend.dto.SensorDTO;

public interface ChemicalSensorService {
    void processChemical(SensorDTO data);
}
