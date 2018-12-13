package fr.ias.ivoa.uws4j.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;
import java.util.UUID;

import org.assertj.core.api.Assertions;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import fr.ias.ivoa.uws4j.UWS;
import fr.ias.ivoa.uws4j.domain.Job;
import fr.ias.ivoa.uws4j.domain.JobList;
import fr.ias.ivoa.uws4j.services.JobService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {JobController.class }, secure=false)
public class JobControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private JobService jobService;

	@Test
	public void testGetJobList() throws Exception {
		
		//__given__
		JobList jobList = new JobList("foo");
		jobList.addJob(new Job());
		when(jobService.getJobListByName(ArgumentMatchers.eq("foo"))).thenReturn(Optional.of(jobList));
		
		//__when_then__
		
		mockMvc.perform(get("/uws/foo"))
			.andExpect(status().isOk())
			.andDo(print())
			.andExpect(jsonPath("$.id").doesNotExist())
			.andExpect(jsonPath("$.name", is("foo")))
			.andExpect(jsonPath("$.version", is(UWS.VERSION)))
			.andExpect(jsonPath("$.jobs.length()", is(1) ));
		
		verify(jobService).getJobListByName(ArgumentMatchers.eq("foo"));
	}

	@Test
	public void testGetJobListNotFound() throws Exception {
		
		//__given__
		JobList jobList = new JobList("foo");
		when(jobService.getJobListByName(ArgumentMatchers.eq("foo"))).thenReturn(Optional.empty());
		
		//__when_then__
		mockMvc.perform(get("/uws/foo"))
			.andExpect(status().isNotFound())
			.andDo(print())
			.andExpect(jsonPath("$.id", notNullValue()))
			.andExpect(jsonPath("$.description", is("Object JobList with name foo not found")))
			.andExpect(jsonPath("$.cause", notNullValue() ));
		
		verify(jobService).getJobListByName(ArgumentMatchers.eq("foo"));
	}

}
