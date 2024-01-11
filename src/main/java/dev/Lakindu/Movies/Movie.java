package dev.Lakindu.Movies;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Annotate the class as documents so the complier knows that this class represents each document in the movie collection
//MySQL Rows = MongoDB Documents
//MySQL Tables = MongoDB Collections
@Document(collection="movies")

//@Data gives all the getters and setter for the class-comes from lombock
@Data

//Creates a constructor that takes all the private fields as an argument
@AllArgsConstructor

//Creates a constructor that takes no arguments
@NoArgsConstructor




public class Movie {
    @Id //Id is the unique identifier for each movie
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backDrops;


    //One to many relationship between Review and Movie can be written as this
    //All the reviews related to this movie goes into this list of reviews

    //@DocumentReference if we use this annotation here then only the ids of the reviews will be stored in the database
    //and actual reviews will be stored in another collection

    //This is called manual referencing
    @DocumentReference
    private List<Review> reviewIds;
}
