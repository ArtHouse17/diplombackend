package art.backend.service.impl;

import art.backend.dto.CommandDTO;
import art.backend.dto.SensorDTO;
import art.backend.kafka.KafkaSender;
import art.backend.service.impl.enums.Chemicalparam;
import art.backend.service.impl.enums.EventTypes;
import art.backend.service.impl.enums.FireParam;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommandFormerServiceImpl {

    private final KafkaSender kafkaSender;

    public CommandFormerServiceImpl(KafkaSender kafkaSender) {
        this.kafkaSender = kafkaSender;
    }

    public void processCommand(SensorDTO data, EventTypes type) {
        StringBuilder sb = new StringBuilder();
        switch (type) {
            case Chemical:
                if (data.getConcentration() < Chemicalparam.CHEMICALPARAM.getParam() && data.getConcentration() > Chemicalparam.NEEDTOCHECK.getParam()) {
                    sendCommand(sb.append("Сообщение оператору! Датчик ").append(data.getId()).append(" превысил дежурное значение!").toString(), "Оператор", 1);
                }else{
                    sendCommand(sb.append("execute(splashing, airintake, sewage)").toString(), "Вентиляционная, противопожарная, канализационная система, экстренные службы", 2);
                }
                break;
            case Fire:
                if (data.getTemperature() < FireParam.FIREPARAM.getParam() && data.getTemperature() > FireParam.NEEDTOCHECK.getParam()) {
                    sendCommand(sb.append("Сообщение оператору! Датчик ").append(data.getId()).append(" превысил дежурное значение!").toString(), "Оператор", 1);
                }else{
                    sendCommand(sb.append("execute(splashing, sewage)").toString(), "Противопожарная система, экстренные службы",3);
                }
        }
    }

    private void sendCommand(String command, String service, Integer id) {
        CommandDTO commandDTO = CommandDTO.builder()
                .id(id)
                .service(service)
                .time(LocalDateTime.now())
                .command(command)
                .build();
        System.out.println(commandDTO);
        kafkaSender.send("topic.text.command", commandDTO);
    }
}
