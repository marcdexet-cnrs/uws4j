package fr.ias.ivoa.uws4j.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ias.ivoa.uws4j.domain.JobList;
import fr.ias.ivoa.uws4j.exceptions.NotFoundException;
import fr.ias.ivoa.uws4j.rest.JobListRepresentation;
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
		 * @param jobListName
		 * @return jobList
		 * @throws NotFoundException 
		 */
		@GetMapping(value="/{jobs}",  produces = "application/json")
		public JobListRepresentation getJobList(@PathVariable("jobs") String jobListName) throws NotFoundException {
			return JobListRepresentation.from( 
					jobService.getJobListByName(jobListName).orElseThrow(() -> new NotFoundException(JobList.class, jobListName))
				);
		}
}
