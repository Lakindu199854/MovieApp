package dev.Lakindu.Movies;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1/movies")
//Here every request that comes to this api endpoint is handled by this controlle  r
public class MovieController {
    @Autowired
    //Using this autowire it will inject a instance of MovieService into the movieService
    private MovieService movieService;
    @GetMapping
    //ResponseEntity is a class which represents the entire http resonse including the headers,body and the status code
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(),HttpStatus.OK);
    }
    
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieByImdbId(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.getMoviByImdbId(imdbId),HttpStatus.OK);
    }
    
}

 