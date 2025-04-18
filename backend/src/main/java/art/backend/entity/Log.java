package art.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Log {
    @Id
    private int id;
    private LocalDateTime timestamp;
    private String eventtype;
    private String description;

    @ManyToOne
    private Sensor sensor;

    @ManyToOne
    private User user;
}
