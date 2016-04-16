package com.kris.research.healthcare.controller;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kris.research.healthcare.controller.rest.resource.DoctorResource;

@Controller
public class DoctorController {

	private static final Logger logger = LogManager.getLogger("DoctorController");

	
	
	
	@RequestMapping(value="/doctor/{doctorId}", method=RequestMethod.GET, consumes="application/json", produces="application/json")
	@ResponseBody
	public HttpEntity<DoctorResource> findDoctor(@PathVariable(value="doctorId")String doctorId) throws IOException {
		logger.info("doctorId : " + doctorId);
		
		return new ResponseEntity<DoctorResource>(new DoctorResource(), HttpStatus.OK);
	}
	

	
}
