package com.example.sampleBatch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Configuration
public class SampleBatchStep {
	//
	@Autowired
	private StepBuilderFactory stepFactory;
	
	@Bean
	public Step sampleStep() {
		return stepFactory.get("sampleStep")
				.tasklet((contribute, chunkContext) -> {
					System.out.println(">>>>>>>>>>>>>> TEST STEP!!!! <<<<<<<<<<<<<<<<<");
					return RepeatStatus.FINISHED;
				})
				.build();
	}
}
