package art.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Location {
    @Id
    private int id;
    private String Name;
    private Double CoordinateX;
    private Double CoordinateY;
}
