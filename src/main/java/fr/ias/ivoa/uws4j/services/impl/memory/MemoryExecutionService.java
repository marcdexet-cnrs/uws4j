package fr.ias.ivoa.uws4j.services.impl.memory;

import org.springframework.stereotype.Component;

import fr.ias.ivoa.uws4j.domain.Job;
import fr.ias.ivoa.uws4j.domain.JobList;
import fr.ias.ivoa.uws4j.domain.Phase;
import fr.ias.ivoa.uws4j.services.ExecutionService;

@Component
public class MemoryExecutionService implements ExecutionService {

	@Override
	public void process(Job job, JobList jobList, Phase phase) {
		// TODO Auto-generated method stub

	}

}
