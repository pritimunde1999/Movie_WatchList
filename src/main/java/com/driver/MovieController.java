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
    public ResponseEntity<String> addMovie(@RequestBody Movie movie)
    {
        String msg = movieService.addMovie(movie);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director)
    {
        String msg = movieService.addDirector(director);
        return new ResponseEntity<>(msg,HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String directorName, @RequestParam String movieName)
    {
        String msg = movieService.addMovieDirectorPair(directorName,movieName);
        return new ResponseEntity<>(msg,HttpStatus.CREATED);
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
       String msg = movieService.deleteDirectorByName(directorName);
       return new ResponseEntity<>(msg,HttpStatus.CREATED);
   }

   @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
   {
      String msg = movieService.deleteAllDirectors();
      return new ResponseEntity<>(msg,HttpStatus.CREATED);
   }
}
