import { useEffect, useState } from 'react';
import '../App.css';
import { getAllMovies } from '../Services/MovieServices';
import { getMoviesByImdbId } from '../Services/MovieServices';


function Home() {
    const [movies,setMovies]=useState();
  
    const getMovies=async()=>{
      try{
        const response=await getAllMovies("/api/v1/movies");
        console.log(response.data);
        setMovies(response.data);
      }catch(err){
        console.log(err);
      }
    }
  
    const getMoviesByImdbId=async()=>{
      try{
        const response=await getMoviesByImdbId("");
        console.log(response.data);
      }catch(e){
        console.log(e);
      }
    }
    
    useEffect(()=>{
      getMovies();
    },[])
  
  
    return (
     <div>
      home
     </div>
    );
  }
  
  export default Home;
  