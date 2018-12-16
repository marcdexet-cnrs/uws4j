package fr.ias.ivoa.uws4j.services;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;

import org.ivoa.uws.Parameters;
import org.springframework.stereotype.Component;

import fr.ias.ivoa.uws4j.domain.Job;
import fr.ias.ivoa.uws4j.domain.JobList;
import fr.ias.ivoa.uws4j.domain.Phase;
import fr.ias.ivoa.uws4j.domain.ScalarJobAttribute;
import fr.ias.ivoa.uws4j.exceptions.NotFoundException;

@Component
public interface JobService {

	/**
	 * Finds a {@link JobList} by its <i>name</i>
	 * @param name
	 * @return Optional of Joblist
	 */
	public Optional<JobList> findJobList(String name);
	
	/**
	 * Gets a {@link JobList} by its <i>name</i>.<br>
	 * If JobList is not found, a {@link NotFoundException} is raised.
	 * @param name
	 * @return
	 * @throws NotFoundException
	 */
	public JobList getJobList(String name) throws NotFoundException;

	/**
	 * Sets job's parameter from a parameters map.
	 * @see Job#getParameters()
	 * @param job
	 * @param params
	 */
	public void setParameters(Job job, Map<String, String> params);
	
	/**
	 * Gets {@link Job} from {@link JobList} by its <i>jobId</i>.<br>
	 * If Job is not found, a {@link NotFoundException} is raised.
	 * @param jobId
	 * @param jobList
	 * @return
	 * @throws NotFoundException
	 */
	public Job getJob(String jobId, JobList jobList) throws NotFoundException;

	/**
	 * Process {@link Job} from {@link JobList} according to {@link Phase}
	 * @param job
	 * @param jobList
	 * @param phase
	 */
	public void process(Job job, JobList jobList, Phase phase);

	/**
	 * Sets execution properties for <i>Job</i>.
	 * @see Job#setRunId(String)
	 * @see Job#setDestruction(java.time.LocalDateTime)
	 * @see Job#setExecutionDuration(Integer)
	 * @param job
	 * @param runid
	 * @param executionduration
	 * @param destruction
	 */
	public void setProperties(Job job, String runid, Integer executionduration, Optional<Instant> destruction);

	/**
	 * Creates and registers a {@link Job} into {@link JobList}
	 * @param jobList
	 * @return
	 */
	public Job createAndRegisterJobForJoblist(JobList jobList);

	public Optional<Object> findJobAttribute(Job job, ScalarJobAttribute attrName);

}
