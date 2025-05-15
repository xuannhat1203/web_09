package com.baitap.session09.modal;
public class Movie {
    private int id;
    private String title;
    private String director;
    private String genre;
    private String description;
    private Integer duration;
    private String language;

    // Constructor không tham số
    public Movie() {
    }

    // Constructor đầy đủ tham số
    public Movie(int id, String title, String director, String genre, String description, Integer duration, String language) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.description = description;
        this.duration = duration;
        this.language = language;
    }

    // Getter và Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    // toString() để dễ in ra thông tin
    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", language='" + language + '\'' +
                '}';
    }
}
