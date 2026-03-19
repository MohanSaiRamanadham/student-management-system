package com.college.StudentManagementSystem;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.apache.tomcat.util.digester.SystemPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.w3c.dom.ls.LSOutput;

@SpringBootApplication
public class StudentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
		System.out.println("********** welcome to the college portal **********");
	}

}
