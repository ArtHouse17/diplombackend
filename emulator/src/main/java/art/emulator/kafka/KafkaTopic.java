package art.emulator.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {
    @Bean
    public NewTopic topic() {
        return TopicBuilder
                .name("topic.text.message")
                .partitions(3)
                .build();
    }
}
