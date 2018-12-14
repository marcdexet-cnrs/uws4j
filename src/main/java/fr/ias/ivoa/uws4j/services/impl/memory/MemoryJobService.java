package fr.ias.ivoa.uws4j.services.impl.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

import fr.ias.ivoa.uws4j.domain.Job;
import fr.ias.ivoa.uws4j.domain.JobList;
import fr.ias.ivoa.uws4j.services.JobService;
import fr.ias.ivoa.uws4j.services.impl.JobServiceSupport;

@Component
public class MemoryJobService extends JobServiceSupport {
	
	
	private Map<String,JobList> jobListByName = new HashMap<>(); 

	@Override
	public Optional<JobList> findJobList(String name) {
		return Optional.ofNullable(jobListByName.get(name));
	}

	@Override
	public void addJobToJobList(Job job, JobList jobList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Job createJobFromParameters(Map<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}

}
