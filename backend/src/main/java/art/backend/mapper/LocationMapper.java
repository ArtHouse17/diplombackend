package art.backend.mapper;

import art.backend.dto.LocationDTO;
import art.backend.entity.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationDTO toDTO(Location location);
}
