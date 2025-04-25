package art.backend.service.impl;

import art.backend.dto.LocationDTO;
import art.backend.dto.SensorDTO;
import art.backend.entity.Location;
import art.backend.service.ChemicalSensorService;
import art.backend.service.LocationService;
import art.backend.service.WorkerSensorService;
import art.backend.service.impl.enums.Chemicalparam;
import art.backend.service.impl.enums.EventTypes;
import art.backend.service.impl.enums.LocationServiceImpl;
import art.backend.websocket.WebSocketServer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class ChemicalSensorImpl implements ChemicalSensorService {
    private final LogsFormerServiceImpl logsFormerServiceImpl;
    private final Chemicalparam chemicalparam = Chemicalparam.NEEDTOCHECK;
    private final WebSocketServer webSocketServer;
    private final CommandFormerServiceImpl commandFormerServiceImpl;
    private final LocationService locationService;
    private final LocationServiceImpl locationServiceImpl;


    @Override
    public void processChemical(SensorDTO data) throws IOException {
        if (data.getConcentration() > chemicalparam.getParam() || data.getConcentration() == null) {
            System.out.println(data.getConcentration());
            logsFormerServiceImpl.processLog(data, EventTypes.Chemical);
            LocationDTO location = locationServiceImpl.getLocation(data);
            data.setCoordX(location.getCoordinatex());
            data.setCoordY(location.getCoordinatey());
            data.setIsDanger(true);
            commandFormerServiceImpl.processCommand(data, EventTypes.Chemical);
        }
        if (webSocketServer != null) {
            webSocketServer.addSensor(data);
        } else {
            throw new IllegalStateException("WebSocketServer is not initialized");
        }
    }
}
