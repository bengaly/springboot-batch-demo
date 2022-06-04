package com.bkonate.springbootbatchdemo.step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;

public class MessageReader implements ItemReader<String> {

    private String[] welcomeMessage = {"Hello World", "Welcome to Springboot Batch Demo."};

    private int messageIndex = 0;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Lire la data à partir d'une source donnée
     *
     * @return String
     * @throws Exception
     */
    @Override
    public String read() throws Exception {

        //Lire et passer le message au processeur pour traitement
        if (messageIndex < welcomeMessage.length) {
            return welcomeMessage[messageIndex++];
        } else {
            messageIndex = 0;
        }
        return null;
    }

}
