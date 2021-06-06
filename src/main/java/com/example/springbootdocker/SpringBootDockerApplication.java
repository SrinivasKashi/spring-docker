package com.example.springbootdocker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
public class SpringBootDockerApplication {

	@RequestMapping("/")
	  public String home() {
		String cmd = "/skopeo --help";
		Runtime run = Runtime.getRuntime();
		Process pr;
		try {
			pr = run.exec(cmd);
			pr.waitFor();
			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line = "";
			while((line = buf.readLine())!= null) {
				System.out.println(line);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	    return "Hello Docker World";
	  }

	  public static void main(String[] args) {
	    SpringApplication.run(SpringBootDockerApplication.class, args);
	  }

}
