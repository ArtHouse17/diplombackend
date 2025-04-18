package art.backend.dto;

import lombok.Data;

@Data
public class SensorDTO {
    private String id;
    private String type;
    private String status;


    private Double temperature;
    private String unit;


    private Double concentration;
    private String gasType;


    private Boolean isDanger;
    private String message;

    private Double coordX;
    private Double coordY;

}

