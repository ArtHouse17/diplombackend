package art.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "log")
@Builder
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime timestamp;
    private String eventtype;
    private String description;

    @ManyToOne
    @JoinColumn(name = "sensor")
    private Sensor sensor;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
