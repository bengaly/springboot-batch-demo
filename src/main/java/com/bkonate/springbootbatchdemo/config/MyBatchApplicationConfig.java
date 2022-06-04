package com.bkonate.springbootbatchdemo.config;

import com.bkonate.springbootbatchdemo.step.MessageProcessor;
import com.bkonate.springbootbatchdemo.step.MessageReader;
import com.bkonate.springbootbatchdemo.step.MessageWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class MyBatchApplicationConfig {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    /**
     * Un Job est fait à l'aide de plusieurs Steps et un step est composée
     *  des taches READ, PROCESS, WRITE  ou bien d'une seule tache( on parle alors de tasklet).
     * @return job
     */
    @Bean
    public Job demoJob() {
        return jobBuilderFactory.get("demoJob")
                .incrementer(new RunIdIncrementer())
                .flow(firstStep())
                .end()
                .build();
    }

    /**
     * Step consiste à l'utilisation d'un ItemReader, ItemProcessor et un ItemWriter.
     * @return step
     */
    @Bean
    public Step firstStep() {
        return stepBuilderFactory.get("firstStep")
                .<String, String> chunk(1)
                .reader(new MessageReader())
                .processor(new MessageProcessor())
                .writer(new MessageWriter())
                .build();
    }
}
