package dev.Lakindu.Movies;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")
//Here every request that comes to this api endpoint is handled by this controlle  r
public class MovieController {
    @GetMapping
    public ResponseEntity<String> allMovies(){
        return new ResponseEntity<String>("All Movies",HttpStatus.OK);
    }
}

 