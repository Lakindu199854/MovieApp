package dev.Lakindu.Movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    //Here we use a mongodb template to update the movie with the new review we have just pushed using the repository
    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String review,String imdbId){
        Review newReview= (Review) reviewRepository.insert(new Review(review));

        //Here we need to say which class needs to be updated
       mongoTemplate.update(Movie.class)
            //Here we are mathcing the column name imbdId inside the database with the imdbId we have recived from the user
            //Here we are identifying the movie that we are updating
            .matching(Criteria.where("imdbId").is(imdbId))
            //Here we apply,and create a new update object which does the job inside the database
            //Here we are pushing the review inside the reviewIds array
            .apply(new Update().push("reviewIds").value(newReview))
            .first(); // Add .first() to execute the update
            return newReview;
    }
}

//Here using the mongo template what we are doing is to perform an update call in the movie class
//In our database each of the movie has an empty array of review ids
//What we are doing here is to update this array and push a new review item to it
