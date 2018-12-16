package com.thales.kafka.consumer.listener;

import com.thales.kafka.consumer.listener.impl.TestListenerImpl;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;

@Configuration
public class MainKafkaListener {

    //private static final String CONSUMER_RECORD = "Consumer Record : {}";
    private static Logger logger = LoggerFactory.getLogger(MainKafkaListener.class);

    private final TestListenerImpl testListener;

    @Autowired
    public MainKafkaListener( //NOSONAR
                              TestListenerImpl testListener) {
        this.testListener = testListener;
    }

    @KafkaListener(topics = "${kafka.topic.test}")
    public void listenKafkaTest(ConsumerRecord<?, ?> consumerRecord, Acknowledgment acknowledgment) {
        logger.info("Listener topic: test", consumerRecord);

        acknowledgment.acknowledge();
        testListener.consumeMessage((String) consumerRecord.value());
    }
}
