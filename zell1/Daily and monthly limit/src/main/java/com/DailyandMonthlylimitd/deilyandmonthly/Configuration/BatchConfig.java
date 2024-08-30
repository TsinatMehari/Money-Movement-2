package com.DailyandMonthlylimitd.deilyandmonthly.Configuration;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Bean
    public Job dailyJob() {
        return jobBuilderFactory.get("dailyJob")
                .incrementer(new RunIdIncrementer())
                .flow(dailyStep())
                .end()
                .build();
    }
    @Bean
    public Step dailyStep() {
        return stepBuilderFactory.get("dailyStep")
                .tasklet(dailyTasklet())
                .build();
    }
    @Bean
    public Tasklet dailyTasklet() {
        return (contribution, chunkContext) -> {
            // Daily task logic
            System.out.println("Running daily task");
            return RepeatStatus.FINISHED;
        };
    }
    @Bean
    public Job monthlyJob() {
        return jobBuilderFactory.get("monthlyJob")
                .incrementer(new RunIdIncrementer())
                .flow(monthlyStep())
                .end()
                .build();
    }
    @Bean
    public Step monthlyStep() {
        return stepBuilderFactory.get("monthlyStep")
                .tasklet(monthlyTasklet())
                .build();
    }
    @Bean
    public Tasklet monthlyTasklet() {
        return (contribution, chunkContext) -> {
            // Monthly task logic
            System.out.println("Running monthly task");
            return RepeatStatus.FINISHED;
        };
    }
}
