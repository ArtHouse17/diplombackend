package art.backend.service.impl;

import art.backend.dao.UserDAO;
import art.backend.dto.SensorDTO;
import art.backend.service.WorkerSensorService;
import org.springframework.stereotype.Service;

@Service
public class WorkerSensorServiceImpl implements WorkerSensorService {
    private final UserDAO userDAO;

    public WorkerSensorServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void processWorker(SensorDTO data) {
        var changeUser = userDAO.findUserByName((data.getId()));
        if  (data.getCoordX() > 0 && data.getCoordX() < 50 && data.getCoordY() > 0 && data.getCoordY() < 50) {
            changeUser.setInbuilding(true);
            System.out.println("В здании");
        }else{
            changeUser.setInbuilding(false);
            System.out.println("Вне здания");
        }
        userDAO.save(changeUser);
    }
}
