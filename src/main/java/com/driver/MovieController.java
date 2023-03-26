package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    ResponseEntity<String> addMovie(@RequestBody Movie movie)
    {
        String msg = movieService.addMovie(movie);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    ResponseEntity<String> addDirector(@RequestBody Director director)
    {
        String msg = movieService.addDirector(director);
        return new ResponseEntity<>(msg,HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    ResponseEntity<String> addMovieDirectorPair(@RequestParam String directorName, @RequestParam String movieName)
    {
        String msg = movieService.addMovieDirectorPair(directorName,movieName);
        return new ResponseEntity<>(msg,HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{movieName}")
    ResponseEntity<Movie> getMovieByName(@PathVariable("movieName") String movieName)
    {
        Movie movie = movieService.getMovieByName(movieName);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{directorName}")
    ResponseEntity<Director> getDirectorByName(@PathVariable("directorName") String directorName)
    {
        Director director = movieService.getDirectorByName(directorName);
        return new ResponseEntity<>(director,HttpStatus.OK);
    }

    @GetMapping("/get-movies-by-director-name/{directorName}")
    ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("directorName") String directorName)
    {
        List<String> list = movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

   @GetMapping("/get-all-movies")
    ResponseEntity<List<String>> findAllMovies()
   {
       List<String> list = movieService.findAllMovies();
       return new ResponseEntity<>(list,HttpStatus.OK);
   }

   @DeleteMapping("/delete-director-by-name")
    ResponseEntity<String> deleteDirectorByName(@RequestParam("directorName") String directorName)
   {
       String msg = movieService.deleteDirectorByName(directorName);
       return new ResponseEntity<>(msg,HttpStatus.OK);
   }

   @DeleteMapping("/delete-all-directors")
    ResponseEntity<String> deleteAllDirectors()
   {
      String msg = movieService.deleteAllDirectors();
      return new ResponseEntity<>(msg,HttpStatus.OK);
   }
}
