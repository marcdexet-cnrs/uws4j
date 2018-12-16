package fr.ias.ivoa.uws4j.services.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import fr.ias.ivoa.uws4j.domain.Job;
import fr.ias.ivoa.uws4j.domain.JobList;
import fr.ias.ivoa.uws4j.domain.Phase;
import fr.ias.ivoa.uws4j.domain.ScalarJobAttribute;
import fr.ias.ivoa.uws4j.exceptions.NotFoundException;
import fr.ias.ivoa.uws4j.services.ExecutionService;
import fr.ias.ivoa.uws4j.services.JobService;

public abstract class JobServiceSupport implements JobService {
	
	private ExecutionService executionService;
	private EnumMap<ScalarJobAttribute,Function<Job,?>> functionByAttr;

	public JobServiceSupport(ExecutionService executionManager) {
		this.executionService = executionManager;
		buildFunctionByAttr();
	}

	private void buildFunctionByAttr() {
		functionByAttr = new EnumMap<>(ScalarJobAttribute.class);
		functionByAttr.put(ScalarJobAttribute.RUNID, Job::getRunId);
		functionByAttr.put(ScalarJobAttribute.QUOTE, Job::getQuote);
		functionByAttr.put(ScalarJobAttribute.PHASE, Job::getPhase);
		functionByAttr.put(ScalarJobAttribute.OWNER, Job::getOwner);
		functionByAttr.put(ScalarJobAttribute.JOBID, Job::getJobId);
		functionByAttr.put(ScalarJobAttribute.EXECUTIONDURATION, Job::getExecutionDuration);
		functionByAttr.put(ScalarJobAttribute.DESTRUCTION, Job::getDestruction);
	}

	@Override
	public JobList getJobList(String jobListName) throws NotFoundException {
		return findJobList(jobListName).orElseThrow(() -> new NotFoundException(JobList.class, jobListName));
	}
	
	@Override
	public Job getJob(String jobId, JobList jobList) throws NotFoundException {
		return jobList.findJob(jobId).orElseThrow(() -> new NotFoundException(JobList.class, jobList.getName(), Job.class, jobId));
	}

	@Override
	public void setParameters(Job job, Map<String, String> params) {
		job.setParameters(new HashMap<>());
		job.getParameters().putAll(params);
	}

	@Override
	public Job createAndRegisterJobForJoblist(JobList jobList) {
		Job job = new Job();
		jobList.addJob(job);
		return job;
	}

	@Override
	public void setProperties(Job job, String runid, Integer executionduration, Optional<Instant> destruction) {
		if( destruction.isPresent()) {
			job.setDestruction(LocalDateTime.ofInstant(destruction.get(), ZoneId.systemDefault()));
		}
		
		job.setExecutionDuration(executionduration);
		
		if ( runid != null ) {
			job.setRunId(runid);
		}
	}

	@Override
	public void process(Job job, JobList jobList, Phase phase) {
		this.executionService.process(job, jobList, phase);
	}
	
	@Override
	public Optional<Object> findJobAttribute(Job job, ScalarJobAttribute attr) {
		Function<Job, ?> fn = functionByAttr.get(attr);
		return Optional.ofNullable(fn.apply(job));
	}
	
	
}
