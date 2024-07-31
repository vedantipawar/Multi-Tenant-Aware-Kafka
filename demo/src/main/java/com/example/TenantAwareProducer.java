package com.example;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Properties;

public class TenantAwareProducer {
    public static void main(String[] args) {
        // Set up Kafka producer configuration
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        ObjectMapper objectMapper = new ObjectMapper();

        // Create and send messages with tenant metadata
        try {
            String[] tenants = {"tenant1", "tenant2"};
            String[] messages = {"production event 1", "test event 1", "production event 2", "test event 2"};

            for (int i = 0; i < messages.length; i++) {
                Message msg = new Message(tenants[i % 2], messages[i]);
                String jsonString = objectMapper.writeValueAsString(msg);
                producer.send(new ProducerRecord<>("shared-topic", null, jsonString));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
}

class Message {
    public String tenant_id;
    public String data;

    public Message(String tenant_id, String data) {
        this.tenant_id = tenant_id;
        this.data = data;
    }
}
