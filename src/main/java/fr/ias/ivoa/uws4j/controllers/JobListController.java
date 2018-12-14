package fr.ias.ivoa.uws4j.controllers;

import java.net.URI;
import java.time.Instant;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import fr.ias.ivoa.uws4j.domain.ExecutionPhase;
import fr.ias.ivoa.uws4j.domain.Job;
import fr.ias.ivoa.uws4j.domain.JobList;
import fr.ias.ivoa.uws4j.exceptions.NotFoundException;
import fr.ias.ivoa.uws4j.services.JobService;

@RestController
@RequestMapping("/uws")
public class JobListController {

	private JobService jobService;

	public JobListController(JobService jobService) {
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
		return jobService.getJobList(jobListName);
	}
	
	@PostMapping(value = "/{jobs}", produces = { "application/json" })
	public ResponseEntity<?> addAJob(@PathVariable("jobs") String jobListName, 
			@RequestParam Map<String, String> params, 
		    @RequestParam(value="RUNID", required=false) String runid,
		    @RequestParam(value="EXECUTIONDURATION", required=false) Integer executionduration,
		    @RequestParam(value="DESTRUCTION", required=false) Instant destruction,
		    @RequestParam(value="PHASE",required=false) ExecutionPhase phase,
		    HttpServletRequest request,
		    HttpServletResponse response,
		    UriComponentsBuilder builder
			) throws NotFoundException {
		
		JobList  jobList = jobService.getJobList(jobListName);
		
		Job job = jobService.createJobFromParameters(createParamFromQuery(params));
		
		jobService.addJobToJobList(job, jobList);
		
		URI uri = builder.path("/uws/job/{id}").buildAndExpand(job.getJobId()).toUri();
		return ResponseEntity.status(303).location(uri).build();
	}

	private Map<String, String> createParamFromQuery(Map<String, String> params) {
		return params;
	}
}
