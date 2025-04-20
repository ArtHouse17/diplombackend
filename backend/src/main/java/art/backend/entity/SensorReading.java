package art.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sensorreading")
public class SensorReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double readingvalue;

    private LocalDateTime timestamp;

    private String unit;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;
}
