package art.backend.service;

import art.backend.dto.SensorDTO;

import java.io.IOException;

public interface ChemicalSensorService {
    void processChemical(SensorDTO data) throws IOException;
}
