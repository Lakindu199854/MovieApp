package dev.Lakindu.Movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
//Movie=Class of the entity
//ObjectId=Unique identifier of the entity
public interface MovieRepository extends MongoRepository<Movie,ObjectId> {

    
} 