package com.bkonate.springbootbatchdemo.step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemWriter;
import java.util.List;

public class MessageWriter implements ItemWriter<String> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * ItemWriter ecrit la donnée reçue dans la destination.
     *
     * @param inputMessage
     * @throws Exception
     */
    @Override
    public void write(List<? extends String> inputMessage) throws Exception {
        for (String outputMsg : inputMessage) {
            System.out.println("Donnée après traitement:- " + outputMsg);
        }
    }

}
