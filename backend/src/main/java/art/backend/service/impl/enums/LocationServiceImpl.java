package art.backend.service.impl.enums;

import art.backend.dao.LocationDAO;
import art.backend.dao.SensorDAO;
import art.backend.dto.LocationDTO;
import art.backend.dto.SensorDTO;
import art.backend.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationDAO locationDAO;
    private final SensorDAO sensorDAO;

    public LocationDTO getLocation(SensorDTO data) {
        var sensor = sensorDAO.findSensorBySensortype(data.getId());
        var findLocation = sensor.getLocation();
        LocationDTO lc = LocationDTO.builder()
                .id(findLocation.getId())
                .name(findLocation.getName())
                .coordinatex(findLocation.getCoordinateX())
                .coordinatey(findLocation.getCoordinateY())
                .build();
        return lc;
    }
}
