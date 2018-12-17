package fr.ias.ivoa.uws4j.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.ivoa.uws.ErrorSummary;
import org.ivoa.uws.Parameters;
import org.ivoa.uws.Results;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ias.ivoa.uws4j.domain.Job;
import fr.ias.ivoa.uws4j.domain.JobList;
import fr.ias.ivoa.uws4j.domain.Result;
import fr.ias.ivoa.uws4j.domain.ScalarJobAttribute;
import fr.ias.ivoa.uws4j.domain.Error;
import fr.ias.ivoa.uws4j.exceptions.NotFoundException;
import fr.ias.ivoa.uws4j.services.ConverterService;
import fr.ias.ivoa.uws4j.services.JobService;

@RestController
@RequestMapping(value="uws", produces= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class JobController {
	
	private JobService jobService;
	private ConverterService converterService;

	public JobController(JobService jobService, ConverterService converterService) {
		this.jobService = jobService;
		this.converterService = converterService;
	}
	
	
	@GetMapping(value="/{jobs}/{jobId}/{attr}", produces= {MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public String getJobAttribute(	@PathVariable("jobs") String jobListName, 
									@PathVariable("jobId") String jobId, 
									@PathVariable("attr") String attrName,
									HttpServletResponse response) throws NotFoundException {
		JobList jobList = jobService.getJobList(jobListName);
		Job job = jobService.getJob(jobId, jobList);
		
		try {
			String seed=  String.valueOf(attrName).toUpperCase();
			ScalarJobAttribute attr = ScalarJobAttribute.valueOf(seed);
			
			Optional<?> opt = jobService.findJobAttribute(job, attr);
			if ( opt.isPresent() ) {
				return String.valueOf(opt.get());
			}
			
		} catch (IllegalArgumentException e) {
			response.setStatus(404);
		}
		return "";
	}
	
	
	@GetMapping(value="/{jobs}/{jobId}/parameters",produces= {MediaType.APPLICATION_JSON_VALUE})
	public Map<String, String> getJobParameters(
			@PathVariable("jobs") String jobListName, 
			@PathVariable("jobId") String jobId) throws NotFoundException {
		JobList jobList = jobService.getJobList(jobListName);
		Job job = jobService.getJob(jobId, jobList);
		return job.getParameters();
	}

	@GetMapping(value="/{jobs}/{jobId}/parameters",produces= {MediaType.APPLICATION_XML_VALUE})
	public Parameters getJobParametersAsXml(
			@PathVariable("jobs") String jobListName, 
			@PathVariable("jobId") String jobId) throws NotFoundException {
		Map<String, String> parameters = getJobParameters(jobListName, jobId);
		return converterService.translateToXML(org.ivoa.uws.Parameters.class, parameters);
	}
	
	

	@GetMapping(value="/{jobs}/{jobId}/error",produces= {MediaType.APPLICATION_JSON_VALUE})
	public Error getJobError(
			@PathVariable("jobs") String jobListName, 
			@PathVariable("jobId") String jobId) throws NotFoundException {
		JobList jobList = jobService.getJobList(jobListName);
		Job job = jobService.getJob(jobId, jobList);
		return job.getError();
	}
	
	@GetMapping(value="/{jobs}/{jobId}/error",produces= {MediaType.APPLICATION_XML_VALUE})
	public ErrorSummary getJobErrorAsXml(
			@PathVariable("jobs") String jobListName, 
			@PathVariable("jobId") String jobId) throws NotFoundException {
		return converterService.translateToXML(org.ivoa.uws.ErrorSummary.class, getJobError(jobListName, jobId));
	}	

	@GetMapping(value="/{jobs}/{jobId}/results",produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<Result> getJobResults(
			@PathVariable("jobs") String jobListName, 
			@PathVariable("jobId") String jobId) throws NotFoundException {
		JobList jobList = jobService.getJobList(jobListName);
		Job job = jobService.getJob(jobId, jobList);
		return job.getResults();
	}

	@GetMapping(value="/{jobs}/{jobId}/results",produces= {MediaType.APPLICATION_XML_VALUE})
	public Results getJobResultsAsXML(
			@PathVariable("jobs") String jobListName, 
			@PathVariable("jobId") String jobId) throws NotFoundException {
		return converterService.translateToXML(org.ivoa.uws.Results.class, getJobResults(jobListName, jobId));
	}

}
