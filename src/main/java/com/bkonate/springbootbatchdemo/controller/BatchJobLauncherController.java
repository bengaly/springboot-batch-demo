package com.bkonate.springbootbatchdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
public class BatchJobLauncherController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job demoJob;

    /**
     * Lancer le job
     *
     * @return String
     * @throws Exception
     */
    @RequestMapping("/job")
    public String jobLauncher() throws Exception {

        Logger logger = LoggerFactory.getLogger(this.getClass());
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            // JobLauncher est une interface pour executer les jobs
            jobLauncher.run(demoJob, jobParameters);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        return "Job lancé avec succès !";
    }
}
