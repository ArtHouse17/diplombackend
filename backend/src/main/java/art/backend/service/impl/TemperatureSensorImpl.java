package art.backend.service.impl;

import art.backend.dto.SensorDTO;
import art.backend.service.TemperatureSensorService;
import art.backend.service.WorkerSensorService;
import art.backend.service.impl.enums.Chemicalparam;
import art.backend.service.impl.enums.EventTypes;
import art.backend.service.impl.enums.FireParam;
import art.backend.service.impl.enums.LocationServiceImpl;
import art.backend.websocket.WebSocketServer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class TemperatureSensorImpl implements TemperatureSensorService {

    private static final FireParam NEEDTOCHECK = FireParam.NEEDTOCHECK;
    private final LogsFormerServiceImpl logsFormerServiceImpl;
    private final CommandFormerServiceImpl commandFormerServiceImpl;
    private final WebSocketServer webSocketServer;
    private final LocationServiceImpl locationServiceImpl;

    @Override
    public void processTemperature(SensorDTO data) {
        if (data.getTemperature() > NEEDTOCHECK.getParam() || data.getTemperature() == null) {
            System.out.println(data.getTemperature());
            logsFormerServiceImpl.processLog(data, EventTypes.Fire);
            var location = locationServiceImpl.getLocation(data);
            data.setCoordX(location.getCoordinatex());
            data.setCoordY(location.getCoordinatey());
            data.setIsDanger(true);
            commandFormerServiceImpl.processCommand(data, EventTypes.Fire);
        }
        if (webSocketServer != null) {
            try {
                webSocketServer.addSensor(data);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalStateException("WebSocketServer is not initialized");
        }
    }
}
