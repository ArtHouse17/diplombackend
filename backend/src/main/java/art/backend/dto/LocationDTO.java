package art.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocationDTO {
    private int id;
    private Double coordinatex;
    private Double coordinatey;
    private String name;
}
