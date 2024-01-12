package dev.Lakindu.Movies;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

   
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    //If there is no movie found then it has to return null
    //Because of that we use optional
    public Optional<Movie> getMoviById(ObjectId id){
        return movieRepository.findById(id);
    }

    public Optional<Movie> getMoviByImdbId(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
