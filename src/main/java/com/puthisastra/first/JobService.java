package com.puthisastra.first;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
	
	@Autowired
	private JobRepository jobRepository;
	
	private Job createJob(String name, Integer salary) {
		Job job = new Job();
		job.setName(name);
		job.setSalary(salary);
		return job;
	}
	
	public void transactionsWithoutAnnotation() {
		jobRepository.save(createJob("first", 10));
		jobRepository.save(createJob("second", 20));
		jobRepository.save(createJob("first", 30));
	}
	
	@Transactional()
	public void transactionsWithAnnotation() {
		jobRepository.save(createJob("first", 10));
		jobRepository.save(createJob("second", 20));
		jobRepository.save(createJob("first", 30));
	}
}
