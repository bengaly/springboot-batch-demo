package com.bkonate.springbootbatchdemo.step;

import org.springframework.batch.item.ItemProcessor;

public class MessageProcessor implements ItemProcessor<String, String> {

    /**
     * Lire la donnée d'entrée à partir de itemReader, et au ItemProcessor d'appliquer la logique metier
     *
     * @param content
     * @return String
     * @throws Exception
     */
    @Override
    public String process(String content) throws Exception {
        return "BATCH TEST - [" + content.toUpperCase() + "]";
    }

}
