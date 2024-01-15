import React from "react";
import Form from "react-bootstrap/Form";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import Button from "react-bootstrap/Button";
import { saveReview } from "../Services/ReviewServices";
import ListGroup from "react-bootstrap/ListGroup";
import Container from "react-bootstrap/esm/Container";
import { getMoviesByImdbId } from "../Services/MovieServices";

import Card from 'react-bootstrap/Card';

const Review = () => {
  const { imdbId } = useParams();
  const [reviewIds, setReviewIds] = useState([]);
  const [movie, setMovie] = useState("");
  const [review, setReview] = useState("");


  const getMovie = async () => {
    try {
      const res = await getMoviesByImdbId(imdbId);
      setReviewIds(res.data.reviewIds);
      setMovie(res.data);
    } catch (error) {
      console.log(error);
    }
  };

  const onSubmit = async (event) => {
    event.preventDefault()
    console.log()
    const data = {
      reviewBody: review,
      imdbId: imdbId,
    };
    getMovie();

    try {
      const res = await saveReview(data);
      console.log(res);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    getMovie();
  }, []);


 

  return (
    
    <container>
    <Card style={{ width: '18rem' }}>
      <Card.Img variant="top" src={movie.poster} />
      <Card.Body>
        <Card.Title>Card Title</Card.Title>
        <Card.Text>
          
        </Card.Text>
        <Button variant="primary">Go somewhere</Button>
      </Card.Body>
    </Card>

    <Form>
        <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
          <Form.Label>Add Review</Form.Label>
          <Form.Control
            as="textarea"
            rows={3}
            onChange={(event) => {
              setReview(event.target.value);
            }}
          />
        </Form.Group>
        <Button variant="primary" type="submit" onClick={onSubmit}>
          Submit
        </Button>
      </Form>
   
      {reviewIds && (
        <Container>
          {reviewIds.map((review,id) => (
            <ListGroup key={review.id}>
              {<ListGroup.Item>${review.body}</ListGroup.Item>}
            </ListGroup>
          ))}
        </Container>
      )}
       </container>
      
   
  );
};

export default Review;
