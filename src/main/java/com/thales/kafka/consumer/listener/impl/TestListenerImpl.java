package com.thales.kafka.consumer.listener.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestListenerImpl {

    @Autowired
    public TestListenerImpl() {

    }

    public void consumeMessage(String message) {

        try {
            if (message != null)
                System.out.println("Chegou aqui - consumindo a mensagem: %s" + message);
                //this.process(message);

        } catch (Exception ex) {
            /*errorMessageRepository.saveAndFlush(new RuntimeException(message, "Erro listener topic: test"));*/
        }
    }
}
