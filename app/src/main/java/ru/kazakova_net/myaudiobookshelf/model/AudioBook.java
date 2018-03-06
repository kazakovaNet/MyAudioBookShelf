package ru.kazakova_net.myaudiobookshelf.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import ru.kazakova_net.myaudiobookshelf.activity.DetailActivity;

public class AudioBook implements Parcelable {
    private static final String AUTHOR = "author";
    private static final String TITLE = "title";
    private static final String YEAR = "year";
    private static final String GENRE = "genre";
    public static final String BOOK = "book";
    private static final String IMAGE_RESOURCE_ID = "imageResourceId";
    private static final String DESCRIPTION = "description";
    private static final String TAG = "MyLog - " + AudioBook.class.getSimpleName();

    private String author;
    private String title;
    private long year;
    private String genre;
    private int imageResourceId;
    private String description;

    /**
     * Create a new AudioBook object.
     *
     * @param author          is the author of an audio-book
     * @param title           is the title of an audio-book
     * @param year            is the year of writing an audio-book
     * @param genre           is a genre of audio-book
     * @param imageResourceId is an id of image resource
     * @param description     is a short description of an audio-book
     */
    public AudioBook(String author, String title, long year, String genre, int imageResourceId, String description) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.imageResourceId = imageResourceId;
        this.description = description;

        Log.d(TAG, "new AudioBook: title = " + this.title);
    }

    private AudioBook(Parcel parcel) {
        Bundle in = parcel.readBundle(getClass().getClassLoader());

        this.author = in.getString(AUTHOR);
        this.title = in.getString(TITLE);
        this.year = in.getLong(YEAR);
        this.genre = in.getString(GENRE);
        this.imageResourceId = in.getInt(IMAGE_RESOURCE_ID);
        this.description = in.getString(DESCRIPTION);
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public long getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();

        bundle.putString(AUTHOR, this.author);
        bundle.putString(TITLE, this.title);
        bundle.putLong(YEAR, this.year);
        bundle.putString(GENRE, this.genre);
        bundle.putInt(IMAGE_RESOURCE_ID, this.imageResourceId);
        bundle.putString(DESCRIPTION, this.description);

        parcel.writeBundle(bundle);
    }

    public static final Creator<AudioBook> CREATOR = new Creator<AudioBook>() {
        @Override
        public AudioBook createFromParcel(Parcel in) {
            return new AudioBook(in);
        }

        @Override
        public AudioBook[] newArray(int size) {
            return new AudioBook[size];
        }
    };
}
