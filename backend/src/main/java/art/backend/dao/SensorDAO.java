package art.backend.dao;

import art.backend.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorDAO extends JpaRepository<Sensor, Integer> {
    Sensor findSensorBySensortype(String sensortype);
}
