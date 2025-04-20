package art.backend.service.impl;

import art.backend.dto.CommandDTO;
import art.backend.dto.SensorDTO;
import art.backend.kafka.KafkaSender;
import art.backend.service.impl.enums.Chemicalparam;
import art.backend.service.impl.enums.EventTypes;
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
                    sendCommand(sb.append("Сообщение оператору! Датчик ").append(data.getId()).append(" превысил дежурное значение!").toString(), "Оператор");
                }else{
                    sendCommand(sb.append("execute(splashing, airintake, sewage").toString(), "Вентиляционная, противопожарная, канализационная система");
                }
        }
    }

    private void sendCommand(String command, String service) {
        CommandDTO commandDTO = CommandDTO.builder()
                .service(service)
                .time(LocalDateTime.now())
                .command(command)
                .build();
        System.out.println(commandDTO);
        // TODO: Дописать отправку через кафку на сервис имитации
        kafkaSender.send("topic.text.command", commandDTO);
    }
}
