package art.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Sensor {
    @Id
    private int id;
    private String sensortype;
    private String status;
    private LocalDateTime installationtime;

    @ManyToOne
    private Location location;
}
