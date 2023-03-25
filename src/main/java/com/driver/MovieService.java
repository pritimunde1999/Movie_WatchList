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

    public String addMovie(Movie movie)
    {
        return movieRepository.addMovie(movie);
    }

    public List<Movie> getMovies()
    {
        HashMap<String,Movie> hm = movieRepository.movieDb;
        List<Movie> ans = new ArrayList<>();
        for(Movie movie: hm.values())
        {
            ans.add(movie);
        }
        return ans;
    }
    public String addDirector(Director director)
    {
        return movieRepository.addDirector(director);
    }

    public String addMovieDirectorPair(String director, String movie)
    {
        return movieRepository.addMovieDirectorPair(director,movie);
    }

    public Movie getMovieByName(String name)
    {
        HashMap<String,Movie> hm = movieRepository.movieDb;
        if(hm.containsKey(name))
        return hm.get(name);
        return null;
    }

    public Director getDirectorByName(String name)
    {
        HashMap<String,Director> hm = movieRepository.directorDb;
        if(hm.containsKey(name))
        return hm.get(name);
        return null;
    }

    public List<String> getMoviesByDirectorName(String name)
    {
       HashMap<String,String> hm = movieRepository.directorMovieDb;
       List<String> list = new ArrayList<>();

       for(String movie: hm.keySet())
       {
           if(hm.get(movie).equals(name))
           {
               list.add(movie);
           }
       }
       return list;
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

    public String deleteDirectorByName(String name)
    {
        String msg = movieRepository.deleteDirectorByName(name);
        return msg;
    }

    public String deleteAllDirectors()
    {
        movieRepository.removeAllDirectors();
        return "All directors Deleted";
    }
}
