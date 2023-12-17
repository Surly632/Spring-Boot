package com.abmhimel.staticcontext;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletResponse;

@SpringBootApplication
@RestController
public class StaticcontextApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaticcontextApplication.class, args);
	}
	@GetMapping("/")
	public void getHomepage(HttpServletResponse response) throws IOException {
		// redirectAttributes.addAttribute("From","Localhost");
		// redirectAttributes.addAttribute("To","Google");
		//  response.setContentType("text/html");
		 response.setContentType("application/octet-stream");
		 response.sendRedirect("index.html");
	}


}
