import axios from "axios";

const base_url="http://localhost:8080";

export const getAllMovies=async(path)=>{
    try{
        const response=await axios.get(base_url+path);
        return response;
    }catch(error){
        
    }
}

export const getMoviesByImdbId=async(imdbId)=>{
    try{
        const response=await axios.get(base_url+"/api/v1/movies/"+imdbId);
        return response;
    }catch(error){

    }
}

