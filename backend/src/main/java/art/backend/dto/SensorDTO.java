package art.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorDTO {
    private String id;
    private String type;
    private String status;
    // Заменить потом класс
    private int location;

    private Double temperature;
    private String unit;


    private Double concentration;
    private String gasType;


    private Boolean isDanger;
    private String message;

    private Double coordX;
    private Double coordY;

}

