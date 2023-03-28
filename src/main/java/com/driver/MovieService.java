package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie)
    {
         movieRepository.addMovie(movie);
    }

    public void addDirector(Director director)
    {
         movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String director, String movie)
    {
        movieRepository.addMovieDirectorPair(director, movie);
    }

    public Movie getMovieByName(String name)
    {
        return movieRepository.getMovieByName(name);
    }

    public Director getDirectorByName(String name)
    {
        return movieRepository.getDirectorByName(name);
    }

    public List<String> getMoviesByDirectorName(String name)
    {
       HashMap<String,List<String>> hm = movieRepository.directorMovieDb;
       return hm.get(name);
    }

    public List<String> findAllMovies()
    {
        HashMap<String,Movie> hm = movieRepository.movieDb;

        List<String> ans = new ArrayList<>();

        for(String movie: hm.keySet())
        {
            ans.add(movie);
        }

        return ans;
    }

    public void deleteDirectorByName(String name)
    {
        movieRepository.deleteDirectorByName(name);

    }

    public void deleteAllDirectors()
    {
        movieRepository.removeAllDirectors();

    }
}
