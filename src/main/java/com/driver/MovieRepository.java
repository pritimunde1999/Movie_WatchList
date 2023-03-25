package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

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
        Iterator<Map.Entry<String, String>> iterator = directorMovieDb.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (movieDb.containsKey(entry.getValue())) {
                iterator.remove();
                movieDb.remove(entry.getKey());
            }
        }
        directorDb.clear();
    }




    public String deleteDirectorByName(String name) {
        //deleted from director db

        for(Map.Entry<String,String> entry : directorMovieDb.entrySet())
        {
            if(entry.getValue().equals(name))
            {
                String movieName = entry.getKey();
                movieDb.remove(movieName);
                directorMovieDb.remove(movieName);
            }
        }
        directorDb.remove(name);
        return "Director and movies are deleted Successfully";
    }

}
