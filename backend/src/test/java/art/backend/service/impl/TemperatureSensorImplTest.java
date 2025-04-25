package art.backend.service.impl;

import art.backend.dao.SensorDAO;
import art.backend.dto.LocationDTO;
import art.backend.dto.SensorDTO;
import art.backend.entity.Location;
import art.backend.entity.Sensor;
import art.backend.service.impl.enums.FireParam;
import art.backend.service.impl.enums.LocationServiceImpl;
import art.backend.websocket.WebSocketServer;
import org.apache.kafka.clients.consumer.internals.SensorBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TemperatureSensorImplTest {

    @Mock
    WebSocketServer webSocketServer;

    @Mock
    CommandFormerServiceImpl commandFormerServiceImpl;

    @Mock
    LocationServiceImpl locationServiceImpl;

    @Mock
    LogsFormerServiceImpl logsFormerServiceImpl;

    @Mock
    SensorDAO sensorDAO;

    @InjectMocks
    private TemperatureSensorImpl temperatureSensor;

    private static final FireParam NEEDTOCHECK = FireParam.NEEDTOCHECK;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void processTemperature() {
        var data = SensorDTO.builder()
                .id("temp2")
                .temperature(35d)
                .unit("celsius")
                .type("temp")
                .build();
        var locationDTO = LocationDTO.builder()
                .id(1)
                .coordinatex(22d)
                .coordinatey(22d)
                .name("temp2")
                        .build();
        Location location = Location.builder()
                .id(1)
                .Name(locationDTO.getName())
                .CoordinateX(locationDTO.getCoordinatex())
                .CoordinateY(locationDTO.getCoordinatey())
                .build();
        var sensor = Sensor.builder()
                .id(1)
                .location(location)
                .installationtime(LocalDateTime.now())
                .sensortype("temp2")
                .status("OK")
                .build();
        when(locationServiceImpl.getLocation(data)).thenReturn(locationDTO);
        when(sensorDAO.findSensorBySensortype(data.getId())).thenReturn(sensor);
        temperatureSensor.processTemperature(data);
        Assertions.assertEquals(35d, data.getTemperature());
        Assertions.assertEquals(22d, locationDTO.getCoordinatex());
        Assertions.assertEquals(22d, locationDTO.getCoordinatey());
        Assertions.assertEquals(true, data.getIsDanger());
    }
}