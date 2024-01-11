package dev.Lakindu.Movies;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Annotate the class as documents so the complier knows that this class represents each document in the movie collection
//MySQL Rows = MongoDB Documents
//MySQL Tables = MongoDB Collections
@Document(collection="reviews")

//@Data gives all the getters and setter for the class-comes from lombock
@Data

//Creates a constructor that takes all the private fields as an argument
@AllArgsConstructor

//Creates a constructor that takes no arguments
@NoArgsConstructor

public class Review {

@Id //Id is the unique identifier for each movie
private ObjectId id;
private String body;

}
