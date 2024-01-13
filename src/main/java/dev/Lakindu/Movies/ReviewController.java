package dev.Lakindu.Movies;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
     
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String ,String> payload){ //Map of key-value pairs
        // When a client sends a request to this endpoint,
        // The payload should be in a format that can be converted into a Map<String, String>.For example, 
        // if it's a JSON payload, it might look like {"key1": "value1", "key2": "value2"}.
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")),HttpStatus.CREATED);
        //Here the 2 values are extracted from the payload and passed as arguments in the createReview()
    }

}
 