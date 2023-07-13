package com.example.BiblioTeca.model;

public class Movie {
    private String movieName = "N/A";
    private String director = "N/A";
    private String releaseYear = "N/A";

    public Movie() {
    }
    public Movie(String movieName) {
        this.movieName = movieName;
    }

    public Movie(String movieName, String director, String releaseYear) {
        this.movieName = movieName;
        if(director != null)
            this.director = director;
        if(releaseYear != null)
            this.releaseYear = releaseYear;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getDirector() {
        return director;
    }

    public String getReleaseYear() {
        return releaseYear;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Movie movie = (Movie)obj;
        if(this.movieName.equalsIgnoreCase(movie.movieName))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", director='" + director + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
