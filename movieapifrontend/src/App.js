import { useEffect, useState } from 'react';
import './App.css';
import { getAllMovies } from './Services/MovieServices';

function App() {
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
  useEffect(()=>{
    getMovies();
  },[])


  return (
   <>
   </>
  );
}

export default App;
