package art.backend.dao;

import art.backend.entity.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorReadingDAO extends JpaRepository<SensorReading, Integer> {
}
