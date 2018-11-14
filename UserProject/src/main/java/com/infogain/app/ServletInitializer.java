package com.infogain.app;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(UserProjectApplication.class);
		/*
		 404 - RESOURCE NOT FOUND
		 400 - BAD REQUEST
		 401 - UNAUTHORIZED
		 415 - UNSUPPORTED TYPE - Representation not supported for the resource
		 500 - SERVER ERROR
		 
		 GET : Should not update anything. Should be idempotent (same result in multiple calls). 
		 Possible Return Codes 200 (OK) + 404 (NOT FOUND) +400 (BAD REQUEST)
		 
		 POST : Should create new resource. Ideally return JSON with link to newly created resource. Same return codes as get possible. 
		 In addition - Return code 201 (CREATED) can be used.
		 
		 PUT : Update a known resource. ex: update client details.
		  Possible Return Codes : 200(OK) + 404 (NOT FOUND) +400 (BAD REQUEST)

		 DELETE : Used to delete a resource. Possible Return Codes : 200(OK).

500 - SERVER ERROR is possible with all the above HTTP methods. In the case of a 500, 
include the contact details of the help desk in the response.
		 */
	}

}
