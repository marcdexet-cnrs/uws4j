package fr.ias.ivoa.uws4j.services;

import fr.ias.ivoa.uws4j.domain.Job;
import fr.ias.ivoa.uws4j.domain.JobList;
import fr.ias.ivoa.uws4j.domain.Phase;

public interface ExecutionService {

	void process(Job job, JobList jobList, Phase phase);

}
