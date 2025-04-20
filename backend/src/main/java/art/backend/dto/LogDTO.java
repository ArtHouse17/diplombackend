package art.backend.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Builder
@Data
public class LogDTO {
    private int id;
    private LocalDateTime timestamp;
    private String eventtype;
    private String description;
    private SensorDTO sensor;
}
