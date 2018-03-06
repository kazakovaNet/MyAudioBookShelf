package ru.kazakova_net.myaudiobookshelf.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import ru.kazakova_net.myaudiobookshelf.model.AudioBook;
import ru.kazakova_net.myaudiobookshelf.adapter.AudioBookAdapter;
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
                2015, "Computers & Technology", R.drawable.pic_1,
                "Gradle is an open source build automation system that introduces a " +
                        "Groovy-based domain-specific language (DSL) to configure projects. Using " +
                        "Gradle makes it easy for Android developers to manage dependencies and set " +
                        "up the entire build process."));
        books.add(new AudioBook("Ronan Schwarz, Phil Dutson, James Steele, Nelson To",
                "The Android Developer's Cookbook: Building Applications with the Android SDK " +
                        "(Developer's Library)", 2017, "Computers & Technology",
                R.drawable.pic_2, "Do you want to get started building apps for Android, " +
                "today’s number one mobile platform? Are you already building Android apps but want " +
                "to get better at it? The Android ™ Developer’s Cookbook, Second Edition, brings " +
                "together all the expert guidance and code you’ll need."));
        books.add(new AudioBook("Tara Westover", "Educated: A Memoir", 2018,
                "Education", R.drawable.pic_7, "Educated is an account of the " +
                "struggle for self-invention. It is a tale of fierce family loyalty, and of the " +
                "grief that comes from severing one’s closest ties."));

        AudioBookAdapter bookAdapter = new AudioBookAdapter(this, books);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(bookAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AudioBook book = (AudioBook) adapterView.getItemAtPosition(i);

                Log.d(TAG, "onItemClick: title = " + book.getTitle());

                startActivity(DetailActivity.getDetailIntent(book, CurrentlyListeningActivity.this));
            }
        });
    }
}
