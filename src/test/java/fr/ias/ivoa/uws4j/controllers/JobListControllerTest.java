package fr.ias.ivoa.uws4j.controllers;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlTemplate;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import fr.ias.ivoa.uws4j.UWS;
import fr.ias.ivoa.uws4j.domain.Job;
import fr.ias.ivoa.uws4j.domain.JobList;
import fr.ias.ivoa.uws4j.exceptions.NotFoundException;
import fr.ias.ivoa.uws4j.services.JobService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {JobListController.class }, secure=false)
public class JobListControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private JobService jobService;

	@Test
	public void testGetJobList() throws Exception {
		
		//__given__
		JobList jobList = new JobList("foo");
		jobList.addJob(new Job());
		when(jobService.getJobList(eq("foo"))).thenReturn(jobList);
		
		//__when_then__
		
		mockMvc.perform(get("/uws/foo"))
			.andExpect(status().isOk())
			.andDo(print())
			.andExpect(jsonPath("$.id").doesNotExist())
			.andExpect(jsonPath("$.name", is("foo")))
			.andExpect(jsonPath("$.version", is(UWS.VERSION)))
			.andExpect(jsonPath("$.jobs.length()", is(1) ));
		
		verify(jobService).getJobList(eq("foo"));
	}

	@Test
	public void testGetJobListNotFound() throws Exception {
		
		//__given__
		when(jobService.getJobList(eq("foo"))).thenThrow(new NotFoundException(JobList.class, "foo"));
		
		//__when_then__
		mockMvc.perform(get("/uws/foo"))
			.andExpect(status().isNotFound())
			.andDo(print())
			.andExpect(jsonPath("$.id", notNullValue()))
			.andExpect(jsonPath("$.description", is("Object JobList with name foo not found")))
			.andExpect(jsonPath("$.cause", notNullValue() ));
		
		verify(jobService).getJobList(eq("foo"));
	}
	
	
	@Test
	public void createAJob() throws Exception {
		//__GIVEN__
		Job job = new Job();
		job.setJobId("any-job-id");
		when(jobService.createAndRegisterJobForJoblist(any())).thenReturn(job);
		
		//__WHEN__THEN_
		mockMvc.perform(post("/uws/foo?a=1&b=foo"))
			.andExpect(status().is(303))
			.andExpect(redirectedUrlTemplate("http://localhost/uws/job/{id}", job.getJobId()));
	}
	

}
