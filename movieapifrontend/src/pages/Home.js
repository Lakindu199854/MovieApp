import { useEffect, useState } from "react";
import "../App.css";
import { getAllMovies } from "../Services/MovieServices";
import { getMoviesByImdbId } from "../Services/MovieServices";
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import { Link } from 'react-router-dom';



function Home() {
  const [movies, setMovies] = useState();

  const getMovies = async () => {
    try {
      const response = await getAllMovies("/api/v1/movies");
      console.log(response.data);
      setMovies(response.data);
    } catch (err) {
      console.log(err);
    }
  };

  const getMoviesByImdbId = async () => {
    try {
      const response = await getMoviesByImdbId("");
      console.log(response.data);
    } catch (e) {
      console.log(e);
    }
  };

  useEffect(() => {
    getMovies();
  }, []);
  
  const handleReview=()=>{
    
  }
  
  

  return (
    <>
      {movies &&
        movies.map((movie, index) => (
          <Card style={{ width: "18rem" }} key={index}>
            <Card.Img variant="top" src={movie.poster}/>
            <Card.Body>
              <Card.Title>{movie.title}</Card.Title>
              <Button variant="primary">Go somewhere</Button>
              <Link to={`/review/${movie.imdbId}`}><Button 
              
              className="Review"
              variant="Secondary"
            
            >
              Review
            </Button>{" "}</Link>
              
            </Card.Body>
          </Card>
        ))}
    </>
  );
  
}

export default Home;
