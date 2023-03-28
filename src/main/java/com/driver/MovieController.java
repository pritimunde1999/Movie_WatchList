package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie)
    {
         movieService.addMovie(movie);
        return new ResponseEntity<>("Movie Added Successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director)
    {
        movieService.addDirector(director);
        return new ResponseEntity<>("Director Added Successfully",HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String directorName, @RequestParam String movieName)
    {
        movieService.addMovieDirectorPair(directorName,movieName);
        return new ResponseEntity<>("Director-Movie Pair Added Successfully",HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{movieName}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("movieName") String movieName)
    {
        Movie movie = movieService.getMovieByName(movieName);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{directorName}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("directorName") String directorName)
    {
        Director director = movieService.getDirectorByName(directorName);
        return new ResponseEntity<>(director,HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{directorName}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("directorName") String directorName)
    {
        List<String> list = movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(list,HttpStatus.CREATED);
    }

   @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies()
   {
       List<String> list = movieService.findAllMovies();
       return new ResponseEntity<>(list,HttpStatus.CREATED);
   }

   @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("directorName") String directorName)
   {
       movieService.deleteDirectorByName(directorName);
       return new ResponseEntity<>("Director and movies are deleted Successfully",HttpStatus.CREATED);
   }

   @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
   {
       movieService.deleteAllDirectors();
      return new ResponseEntity<>("All directors Deleted",HttpStatus.CREATED);
   }
}
