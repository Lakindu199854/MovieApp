import axios from "axios";

const base_url="http://localhost:8080";

export const getAllMovies=async(path)=>{
    try{
        const response=await axios.get(base_url+path);
        return response;
    }catch(error){
        
    }
}

export const getMoviesByImdbId=async(path)=>{
    try{
        const response=await axios.get(base_url+path);
        return response;
    }catch(error){

    }
}


