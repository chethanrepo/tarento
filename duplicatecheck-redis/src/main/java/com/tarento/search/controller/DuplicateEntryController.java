package com.tarento.search.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tarento.search.component.DuplicateEntryComponent;
import com.tarento.search.entity.DuplicateEntry;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import static javax.servlet.http.HttpServletResponse.SC_CREATED;
import static javax.servlet.http.HttpServletResponse.SC_FOUND;

import java.io.IOException;

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;

@RestController
@CrossOrigin
@RequestMapping("/")
public class DuplicateEntryController {
	
	@Autowired
	DuplicateEntryComponent duplicateEntryComponent;
	
	@ApiOperation(value = "The input to the API would be a 20 character (alphanumeric) key. " + 
			" The endpoint should check if the key has been sent to the API before and "
			+ "return true in that case. The endpoint should return false if the key is coming "
			+ "in for the first time. ", response = DuplicateEntry.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "If the search string does no exists and added"),
	        @ApiResponse(code = 302, message = "If the serach string already exists"),
	        @ApiResponse(code = 400, message = "If the serach string is not of alphanumeric and not 20 chars in length") })	
	
	@RequestMapping(value="/duplicatecheck", method = { RequestMethod.GET, RequestMethod.POST}, produces = "application/json")
	public DuplicateEntry verifyAndAddEntry(@RequestParam(value="searchString", required = true)  String searchString,
					HttpServletRequest request , HttpServletResponse response) throws IOException {	
		
		DuplicateEntry de = null;
		if(isAlphaNumeric(searchString)) {
			de = duplicateEntryComponent.getDuplicateEntry(searchString);
			if(de.getState()) {
				response.setStatus(SC_FOUND);
			} else {
				response.setStatus(SC_CREATED);
			}
		}else {
			de = new DuplicateEntry(searchString);
			response.sendError(SC_BAD_REQUEST, "Input string is of invalid format, should be alphanumeric 20 chars length");
		}
		
		return de;
	}
	
	private boolean isAlphaNumeric(String s){
	    String pattern= "^[a-zA-Z0-9]{20}$";
	    return s.matches(pattern);
	}

}
