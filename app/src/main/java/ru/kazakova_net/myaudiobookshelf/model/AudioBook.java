package ru.kazakova_net.myaudiobookshelf.model;

public class AudioBook {
    private String author;
    private String title;
    private int year;
    private String genre;
    private int imageResourceId;

    /**
     * Create a new AudioBook object.
     *
     * @param author is the author of an audio-book
     * @param title  is the title of an audio-book
     * @param year   is the year of writing an audio-book
     * @param genre  is a genre of audio-book
     */
    public AudioBook(String author, String title, int year, String genre, int imageResourceId) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.imageResourceId = imageResourceId;
    }

    String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    int getImageResourceId() {
        return imageResourceId;
    }
}
