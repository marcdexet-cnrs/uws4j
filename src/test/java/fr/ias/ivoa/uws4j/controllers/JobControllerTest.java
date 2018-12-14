package fr.ias.ivoa.uws4j.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import fr.ias.ivoa.uws4j.services.JobService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {JobController.class }, secure=false)
public class JobControllerTest {
	
	@Autowired MockMvc mvc;
	
	@MockBean JobService jobService;
	
	@Test
	public void getOk() throws Exception {
		
	}

}
