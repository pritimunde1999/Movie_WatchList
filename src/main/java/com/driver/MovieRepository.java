package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    HashMap<String,Movie> movieDb = new HashMap<>();
    HashMap<String,Director> directorDb = new HashMap<>();
    HashMap<String, List<String>> directorMovieDb = new HashMap<>();

    public void addMovie(Movie movie)
    {
        String key = movie.getName();
        movieDb.put(key,movie);

    }

    public void addDirector(Director director)
    {
        String key = director.getName();
        directorDb.put(key,director);

    }

    public Movie getMovieByName(String name)
    {
        return movieDb.get(name);
    }

    public Director getDirectorByName(String name)
    {
        return directorDb.get(name);
    }


    public void addMovieDirectorPair(String director, String movie)
    {
        if(directorMovieDb.containsKey(director))
        {
            directorMovieDb.get(director).add(movie);
        }
        else
        {
            List<String> list = new ArrayList<>();
            list.add(movie);
            directorMovieDb.put(director,list);
        }

    }

    public void removeAllDirectors()
    {
        List<String> movies = new ArrayList<>();

        for (List<String> list : directorMovieDb.values())
        {
            for(String s : list)
            {
                movies.add(s);
            }
        }

        for (String s: movies)
        {
            movieDb.remove(s);
        }
        directorDb.clear();
        directorMovieDb.clear();
    }




    public void deleteDirectorByName(String name) {
        //deleted from director db

        List<String> movies = directorMovieDb.get(name);

        for (String s: movies)
        {
            movieDb.remove(s);
        }

        directorDb.remove(name);
        directorMovieDb.remove(name);


    }

}
