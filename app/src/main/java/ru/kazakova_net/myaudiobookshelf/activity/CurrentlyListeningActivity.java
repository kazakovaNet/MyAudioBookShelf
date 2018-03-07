package ru.kazakova_net.myaudiobookshelf.activity;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
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

        // This adds a left-facing caret alongside the app icon and enables it
        // as an action button such that when the user presses it, your activity receives
        // a call to onOptionsItemSelected().
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Create a list of currently listening audio-books
        ArrayList<AudioBook> books = new ArrayList<>();
        books.add(new AudioBook(
                getString(R.string.author_2),
                getString(R.string.title_2),
                2015,
                getString(R.string.genre_2),
                R.drawable.pic_1,
                getString(R.string.description_2)));
        books.add(new AudioBook(
                getString(R.string.author_3),
                getString(R.string.title_3),
                2017,
                getString(R.string.genre_2),
                R.drawable.pic_2,
                getString(R.string.description_3)));
        books.add(new AudioBook(
                getString(R.string.author_4),
                getString(R.string.title_4),
                2018,
                getString(R.string.genre_3),
                R.drawable.pic_7,
                getString(R.string.description_4)));

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected: id = " + item.getItemId());

        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
