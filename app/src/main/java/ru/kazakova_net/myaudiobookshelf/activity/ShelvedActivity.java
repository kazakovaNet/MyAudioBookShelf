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

public class ShelvedActivity extends AppCompatActivity {
    private static final String TAG = "MyLog - " + ShelvedActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate");

        setContentView(R.layout.book_list);

        // Create a list of currently listening audio-books
        ArrayList<AudioBook> books = new ArrayList<>();
        books.add(new AudioBook("Dmitry Jemerov, Svetlana Isakova", "Kotlin in Action",
                2017, "Computers & Technology", R.drawable.pic_4,
                "Kotlin in Action guides experienced Java developers from the language " +
                        "basics of Kotlin all the way through building applications to run on the " +
                        "JVM and Android devices. Foreword by Andrey Breslav, Lead Designer of Kotlin."));
        books.add(new AudioBook("Kyle Mew", "Android Design Patterns and Best Practices",
                2016, "Programming", R.drawable.pic_5,
                "Are you an Android developer with some experience under your belt? Are " +
                        "you wondering how the experts create efficient and good-looking apps? " +
                        "Then your wait will end with this book!"));
        books.add(new AudioBook("William Shakespeare", "A Midsummer Night's Dream",
                2018, "Classics", R.drawable.pic_6,
                "A Midsummer Night’s Dream is a comedy written by William Shakespeare " +
                        "between 1590 and 1596. It is one of his most played pieces. The events " +
                        "of the play take place in and around Athens in ancient Greece and include " +
                        "scenes from a fairytale world inhabited by characters from Greek mythology."));

        AudioBookAdapter bookAdapter = new AudioBookAdapter(this, books);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(bookAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AudioBook book = (AudioBook) adapterView.getItemAtPosition(i);

                Log.d(TAG, "onItemClick: title = " + book.getTitle());

                startActivity(DetailActivity.getDetailIntent(book, ShelvedActivity.this));
            }
        });
    }
}
