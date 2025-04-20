package art.emulator.service;

import art.backend.dto.SensorDTO;

public interface EmulationService {
    public SensorDTO emulateTemperatureSensor();
    public SensorDTO emulatePressureSensor();
    public SensorDTO emulateChemicalSensor();
    public SensorDTO emulateWorkerSensor();
}
