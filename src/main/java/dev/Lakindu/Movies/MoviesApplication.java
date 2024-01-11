package dev.Lakindu.Movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@RestController
public class MoviesApplication {

		public static void main(String[] args) {
			SpringApplication.run(MoviesApplication.class, args);
		}

		@GetMapping("/root")
		public String root(){
			return "Hello World";
		} 

}
