import { useEffect, useState } from 'react';
import './App.css';
import { getAllMovies } from './Services/MovieServices';
import { getMoviesByImdbId } from './Services/MovieServices';
import { Routes, Route, BrowserRouter } from "react-router-dom";
import Home from "./pages/Home";
import Layout from './Layout'; 

function App() {
 


  return (
    <BrowserRouter>
      <Routes>
        {/* <Route path="/" element={<Users />} /> */}

          <Route path="/" element={<Layout />}>
            {/* <Route path="/" element={<Users/>}/>  */}
            <Route path="/home" element={<Home />} />
          </Route>
  
      </Routes>
    </BrowserRouter>
  );
}

export default App;
