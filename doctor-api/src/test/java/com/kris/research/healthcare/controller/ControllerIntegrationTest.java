package com.kris.research.healthcare.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:spring/mvc-core-config.xml")
@ActiveProfiles("T2")
@Ignore
public class ControllerIntegrationTest {

	@Autowired
    private WebApplicationContext wac;
    
    private MockMvc mockMvc;
    
    @Before
    public void setup() {
    	this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    
    
	@Test
	public void testLaunchAllocator() throws Exception {
		
		this.mockMvc.perform(post("/doctor/123").content("{}").header("content-type", "application/json").accept(MediaType.parseMediaType("application/json")))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"))
			.andExpect(jsonPath("$.jobRun.jobExitStatus").value(1));

	}
	
	@Test
	public void testOutputFile_singleFile() throws Exception {
		this.mockMvc.perform(get("/allocator/run/12121/outputfile").content("{}").header("content-type", "application/json").accept(MediaType.parseMediaType("application/json")))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
		.andExpect(jsonPath("$.jobRun.jobExitStatus").value(1));	
	}
	
	
	@Test
	public void testAllocatedPocs() throws Exception {
		this.mockMvc.perform(post("/allocator/allocatedpocs/search").content("{\"runId\":\"PR-140\",\"campaignId\":\"P-112\",\"cifIds\":[\"00000047117\",\"0000002097\",\"00000226\"]}").header("content-type", "application/json").accept(MediaType.parseMediaType("application/json")))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
		.andExpect(jsonPath("$.[0].branch").value("2652"));
			
	}
	
}
