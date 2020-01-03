package ru.kazakova_net.myaudiobookshelf.activity;

import androidx.core.app.NavUtils;
import androidx.appcompat.app.AppCompatActivity;
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

public class ShelvedActivity extends AppCompatActivity {
    private static final String TAG = "MyLog - " + ShelvedActivity.class.getSimpleName();

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
                getString(R.string.author_5),
                getString(R.string.title_5),
                2017,
                getString(R.string.genre_2),
                R.drawable.pic_4,
                getString(R.string.description_5)));
        books.add(new AudioBook(
                getString(R.string.author_6),
                getString(R.string.title_6),
                2016,
                getString(R.string.genre_2),
                R.drawable.pic_5,
                getString(R.string.description_6)));
        books.add(new AudioBook(
                getString(R.string.author_7),
                getString(R.string.title_7),
                2018,
                getString(R.string.genre_4),
                R.drawable.pic_6,
                getString(R.string.description_7)));

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
