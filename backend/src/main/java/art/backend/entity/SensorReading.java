package art.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class SensorReading {
    @Id
    private Long id;

    private Double readingvalue;

    private LocalDateTime timestamp;

    private String unit;

    @ManyToOne
    private SensorReading sensorReading;
}
