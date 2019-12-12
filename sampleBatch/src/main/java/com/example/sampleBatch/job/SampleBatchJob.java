package com.example.sampleBatch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.sampleBatch.step.SampleBatchStep;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class SampleBatchJob {
	//
	@Autowired
	private JobBuilderFactory jobFactory;
	
	@Autowired
	private SampleBatchStep sampleStep;
	
	@Bean
	public Job sampleJob() {
		return jobFactory.get("sampleJob")
			.start(sampleStep.sampleStep())
			.build();
	}
}
