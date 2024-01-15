import axios from "axios";

const base_url="http://localhost:8080/api/v1/reviews";

export const saveReview=async(path)=>{
    try{
        const response=await axios.post(base_url,path);
        return response;
    }catch(error){
        
    }
}




