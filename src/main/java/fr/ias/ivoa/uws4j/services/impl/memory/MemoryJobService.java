package fr.ias.ivoa.uws4j.services.impl.memory;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import fr.ias.ivoa.uws4j.domain.JobList;
import fr.ias.ivoa.uws4j.services.ExecutionService;
import fr.ias.ivoa.uws4j.services.impl.JobServiceSupport;

@Component
public class MemoryJobService extends JobServiceSupport {
	
	
	public MemoryJobService(ExecutionService executionManager) {
		super(executionManager);
	}

	private Map<String,JobList> jobListByName = new ConcurrentHashMap<>(); 

	@Override
	public Optional<JobList> findJobList(String name) {
		return Optional.ofNullable(jobListByName.get(name));
	}


}
