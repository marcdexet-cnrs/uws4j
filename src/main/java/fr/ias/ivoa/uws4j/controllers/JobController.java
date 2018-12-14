package fr.ias.ivoa.uws4j.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.ias.ivoa.uws4j.domain.Job;
import fr.ias.ivoa.uws4j.domain.JobList;
import fr.ias.ivoa.uws4j.exceptions.NotFoundException;
import fr.ias.ivoa.uws4j.services.JobService;

@RestController
@RequestMapping("/uws")
public class JobController {

	private JobService jobService;

	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	/**
	 * See REQ-API-0001
	 * 
	 * @param jobListName
	 * @return jobList
	 * @throws NotFoundException
	 */
	@GetMapping(value = "/{jobs}", produces = "application/json")
	public JobList getJobList(@PathVariable("jobs") String jobListName) throws NotFoundException {
		return jobService.getJobListByName(jobListName);
	}

	@PostMapping(value = "/{jobs}", produces = { "application/json" })
	public void addAJob(@PathVariable("jobs") String jobListName, @RequestParam Map<String, String> params) throws NotFoundException {
		
		JobList  jobList = jobService.getJobListByName(jobListName);
		Job job = jobService.createJobFromParameters( createParamFromQuery(params));
		jobService.addJobToJobList(job, jobList);
	}

	private Map<String, String> createParamFromQuery(Map<String, String> params) {
		return params;
	}
}
