package dev.Lakindu.Movies;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
//Movie=Class of the entity
//ObjectId=Unique identifier of the entity
public interface MovieRepository extends MongoRepository<Movie,ObjectId> {
    //Just by writing this springData mongodb understands what we want to do
    Optional<Movie> findMovieByImdbId(String imdbId);
    
} 