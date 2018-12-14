package fr.ias.ivoa.uws4j.services.impl;

import fr.ias.ivoa.uws4j.domain.Job;
import fr.ias.ivoa.uws4j.domain.JobList;
import fr.ias.ivoa.uws4j.exceptions.NotFoundException;
import fr.ias.ivoa.uws4j.services.JobService;

public abstract class JobServiceSupport implements JobService {

	@Override
	public JobList getJobList(String jobListName) throws NotFoundException {
		return findJobList(jobListName).orElseThrow(() -> new NotFoundException(JobList.class, jobListName));
	}
	
	@Override
	public Job getJob(String jobId, JobList jobList) throws NotFoundException {
		return jobList.findJob(jobId).orElseThrow(() -> new NotFoundException(JobList.class, jobList.getName(), Job.class, jobId));
	}

}
