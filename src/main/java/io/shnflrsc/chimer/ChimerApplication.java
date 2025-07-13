package io.shnflrsc.chimer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ChimerApplication {

	@RequestMapping("/")
	String home() {
		return "Hello world";
	}

	public static void main(String[] args) {
		SpringApplication.run(ChimerApplication.class, args);
	}
}
