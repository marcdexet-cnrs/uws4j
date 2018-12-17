package fr.ias.ivoa.uws4j.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

import org.ivoa.uws.Parameter;
import org.ivoa.uws.Parameters;
import org.ivoa.uws.ResultReference;
import org.ivoa.uws.Results;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import fr.ias.ivoa.uws4j.configuration.JaxbConfig;
import fr.ias.ivoa.uws4j.domain.ExecutionPhase;
import fr.ias.ivoa.uws4j.domain.Job;
import fr.ias.ivoa.uws4j.domain.JobList;
import fr.ias.ivoa.uws4j.domain.Result;
import fr.ias.ivoa.uws4j.domain.ScalarJobAttribute;
import fr.ias.ivoa.uws4j.services.ConverterService;
import fr.ias.ivoa.uws4j.services.JobService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {JobController.class }, secure=false)
@Import(JaxbConfig.class)
public class JobControllerTest {
	
	@Autowired MockMvc mvc;
	
	@MockBean JobService jobService;
	@MockBean ConverterService converterService;
	
	@Test
	public void getAttributes() throws Exception {
		
		// __GIVEN
		Job job = new Job();
		job.setJobId("123456");
		job.setRunId("run_id_999");
		LocalDateTime destruction = LocalDateTime.now().plusHours(2);
		job.setDestruction(destruction);
		job.setExecutionDuration(200);
		job.setOwner("owner");
		job.setPhase(ExecutionPhase.COMPLETED.toString());
		LocalDateTime quote = LocalDateTime.now().plusHours(1);
		job.setQuote(quote);

		JobList jobList = new JobList("xmatch");

		when(jobService.getJobList("xmatch")).thenReturn(jobList);
		when(jobService.getJob(eq("123456"), eq(jobList))).thenReturn(job);

		when(jobService.findJobAttribute(eq(job), eq(ScalarJobAttribute.RUNID))).thenReturn(Optional.of("run_id_999"));
		when(jobService.findJobAttribute(eq(job), eq(ScalarJobAttribute.JOBID))).thenReturn(Optional.of("123456"));
		when(jobService.findJobAttribute(eq(job), eq(ScalarJobAttribute.DESTRUCTION)))
				.thenReturn(Optional.of(destruction));
		when(jobService.findJobAttribute(eq(job), eq(ScalarJobAttribute.QUOTE))).thenReturn(Optional.of(quote));
		when(jobService.findJobAttribute(eq(job), eq(ScalarJobAttribute.EXECUTIONDURATION)))
				.thenReturn(Optional.of(200));
		when(jobService.findJobAttribute(eq(job), eq(ScalarJobAttribute.OWNER))).thenReturn(Optional.of("owner"));
		when(jobService.findJobAttribute(eq(job), eq(ScalarJobAttribute.PHASE)))
				.thenReturn(Optional.of(ExecutionPhase.COMPLETED.toString()));

		Map<ScalarJobAttribute, Object> expectations = new EnumMap<>(ScalarJobAttribute.class);
		expectations.put(ScalarJobAttribute.RUNID, "run_id_999");
		expectations.put(ScalarJobAttribute.JOBID, "123456");
		expectations.put(ScalarJobAttribute.DESTRUCTION, destruction);
		expectations.put(ScalarJobAttribute.QUOTE, quote);
		expectations.put(ScalarJobAttribute.EXECUTIONDURATION, 200);
		expectations.put(ScalarJobAttribute.OWNER, "owner");
		expectations.put(ScalarJobAttribute.PHASE, ExecutionPhase.COMPLETED.toString());

		for (ScalarJobAttribute attr : ScalarJobAttribute.values()) {
			try {
				MvcResult result = mvc.perform(get("/uws/xmatch/123456/{attr}", attr.toString().toLowerCase()))
						.andExpect(status().isOk()).andReturn();

				Object expected = expectations.get(attr);
				assertThat(result.getResponse().getContentAsString()).as("Expectation for %s}", attr)
						.isEqualTo(String.valueOf(expected));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				throw e;
			}
		}
	}
			
	@Test
	public void getUnexpectedAttr() throws Exception {
		//__GIEVN__
		when(jobService.findJobAttribute(any(), any())).thenThrow(new IllegalArgumentException("getUnexpectedAttr"));
		
		// WHEN_THEN
		mvc.perform(get("/uws/xmatch/123456/foo"))
				.andExpect(status().isNotFound());
	}

	@Test
	public void getParameters() throws Exception {
		// GIVEN
		JobList jobList = new JobList("xmatch");
		
		when(jobService.getJobList("xmatch")).thenReturn(jobList);
		Job job = new Job();
		job.setParameters(new LinkedHashMap<>());
		job.getParameters().put("foo", "bar");
		job.getParameters().put("nb", "1");
		
		when(jobService.getJob(eq("123456"), eq(jobList))).thenReturn(job);

		// WHEN_THEN
		MvcResult result = mvc.perform(get("/uws/xmatch/123456/parameters").accept(APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		
		assertThat(result.getResponse().getContentAsString()).isEqualTo("{\"foo\":\"bar\",\"nb\":\"1\"}");
	}
		
	@Test
	public void getParametersAsXML() throws Exception {
		// GIVEN
		Job job = new Job();
		JobList jobList = new JobList("xmatch");
		when(jobService.getJobList("xmatch")).thenReturn(jobList);
		when(jobService.getJob(eq("123456"), eq(jobList))).thenReturn(job);
		
		
		Parameters xmlParameters = new Parameters();
		Parameter parm = new Parameter();
		parm.setId("foo");
		parm.setContent("bar");
		xmlParameters.getParameter().add(parm);
		
		
		when(converterService.translateToXML(eq(Parameters.class), any())).thenReturn(xmlParameters);
		
		
		// WHEN_THEN
		MvcResult result = mvc.perform(get("/uws/xmatch/123456/parameters").accept(APPLICATION_XML_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		
		assertThat(result.getResponse().getContentAsString())
			.isEqualTo("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
					+ "<parameters xmlns=\"http://www.ivoa.net/xml/UWS/v1.0\" "
					+ "xmlns:ns2=\"http://www.w3.org/1999/xlink\">"
					+ "<parameter id=\"foo\">bar</parameter>"
					+ "</parameters>");
	}
		
	


	@Test
	public void getResult() throws Exception {
		// GIVEN
		JobList jobList = new JobList("xmatch");
		
		when(jobService.getJobList("xmatch")).thenReturn(jobList);
		Job job = new Job();
		
		

		// WHEN_THEN
		Result r =  new Result();
		r.setHref("http://from/nowhere");
		r.setId("foo");
		r.setMimeType("mimetype");
		r.setType("png");
		r.setSize(10L);
		job.setResults(new LinkedList<>());
		job.getResults().add(r);
		
		when(jobService.getJob(eq("123456"), eq(jobList))).thenReturn(job);
		MvcResult result = mvc.perform(get("/uws/xmatch/123456/results").accept(APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		
		assertThat(result.getResponse().getContentAsString())
			.isEqualTo("[{\"id\":\"foo\","
					+ "\"href\":\"http://from/nowhere\","
					+ "\"type\":\"png\","
					+ "\"mimeType\":\"mimetype\","
					+ "\"redirection\":false,"
					+ "\"size\":10}]");
	}

	
	public void getResultAsXml() throws Exception {

		// GIVEN
		Results results = new Results();
		
		ResultReference r = new ResultReference();
		r.setHref("http://from/nowhere");
		r.setId("foo");
		r.setMimeType("mimetype");
		r.setType("png");
		r.setSize(10L);
		results.getResult().add(r);
		when(converterService.translateToXML(eq(Results.class), any())).thenReturn(results);

		// WHEN_THEN

		MvcResult result = mvc.perform(get("/uws/xmatch/123456/results").accept(APPLICATION_XML_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		
		assertThat(result.getResponse().getContentAsString())
			.isEqualTo("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
					+ "<results xmlns=\"http://www.ivoa.net/xml/UWS/v1.0\" "
					+ "xmlns:ns2=\"http://www.w3.org/1999/xlink\">"
					+ "<result id=\"foo\" size=\"10\" mime-type=\"mimetype\" ns2:type=\"png\" ns2:href=\"http://from/nowhere\"/>"
					+ "</results>");
	}			

}
