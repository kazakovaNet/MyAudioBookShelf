package ru.kazakova_net.myaudiobookshelf.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import ru.kazakova_net.myaudiobookshelf.model.AudioBook;
import ru.kazakova_net.myaudiobookshelf.model.AudioBookAdapter;
import ru.kazakova_net.myaudiobookshelf.R;

public class CurrentlyListeningActivity extends AppCompatActivity {
    private static final String TAG = "MyLog - " + CurrentlyListeningActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate");

        setContentView(R.layout.book_list);

        // Create a list of currently listening audio-books
        ArrayList<AudioBook> books = new ArrayList<>();
        books.add(new AudioBook("Kevin Pelgrims", "Gradle for Android",
                2015, "Computers & Technology", R.drawable.pic_1));
        books.add(new AudioBook("Ronan Schwarz, Phil Dutson, James Steele, Nelson To",
                "The Android Developer's Cookbook: Building Applications with the Android SDK (Developer's Library)",
                2017, "Computers & Technology", R.drawable.pic_2));

        AudioBookAdapter bookAdapter = new AudioBookAdapter(this, books);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(bookAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AudioBook book = (AudioBook) adapterView.getItemAtPosition(i);

                Log.d(TAG, "onItemClick: title = " + book.getTitle());

                Intent detailIntent = new Intent(CurrentlyListeningActivity.this, DetailActivity.class);
                startActivity(detailIntent);
            }
        });
    }
}
