package art.backend.kafka;

import org.springframework.stereotype.Component;

@Component
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(topics = "example", groupId = "group1")
    void listener(String data) {
        System.out.println(data);
    }
}
