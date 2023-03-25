package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    HashMap<String,Movie> movieDb = new HashMap<>();
    HashMap<String,Director> directorDb = new HashMap<>();
    HashMap<String, String> directorMovieDb = new HashMap<>();

    public String addMovie(Movie movie)
    {
        String key = movie.getMovieName();
        movieDb.put(key,movie);
        return "Movie Added Successfully";
    }

    public String addDirector(Director director)
    {
        String key = director.getDirectorName();
        directorDb.put(key,director);
        return "Director Added Successfully";
    }

    public String addMovieDirectorPair(String director, String movie)
    {
        directorMovieDb.put(movie,director);
        return "Director-Movie Paired Successfully";

    }

    public void removeAllDirectors()
    {
        directorDb.clear();

        for(String movie: directorMovieDb.keySet())
        {
            if(!(directorMovieDb.get(movie).equals(null)))
            {
                directorMovieDb.remove(movie);
                if(movieDb.containsKey(movie))
                {
                    movieDb.remove(movie);
                }
            }
        }
    }




    public String deleteDirectorByName(String name) {
        //deleted from director db
        directorDb.remove(name);
        for(Map.Entry<String,String> entry : directorMovieDb.entrySet())
        {
            if(entry.getValue().equals(name))
            {
                String movieName = entry.getKey();
                movieDb.remove(movieName);
                directorMovieDb.remove(movieName);
            }
        }
        return "Director and movies are deleted Successfully";
    }

}
