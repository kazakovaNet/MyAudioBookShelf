package ru.kazakova_net.myaudiobookshelf.activity;

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

public class ArchiveActivity extends AppCompatActivity {
    private static final String TAG = "MyLog - " + ArchiveActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate");

        setContentView(R.layout.book_list);

        // Create a list of currently listening audio-books
        ArrayList<AudioBook> books = new ArrayList<>();
        books.add(new AudioBook("Stephen R. Covey",
                "The 7 Habits of Highly Effective People: Powerful Lessons in Personal Change ",
                2013, "Personal effectiveness", R.drawable.pic_3,
                "One of the most inspiring and impactful books ever written, " +
                        "The 7 Habits of Highly Effective People has captivated readers for 25 years. " +
                        "It has transformed the lives of Presidents and CEOs, educators and parents— " +
                        "in short, millions of people of all ages and occupations."));

        AudioBookAdapter bookAdapter = new AudioBookAdapter(this, books);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(bookAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AudioBook book = (AudioBook) adapterView.getItemAtPosition(i);

                Log.d(TAG, "onItemClick: title = " + book.getTitle());

                startActivity(DetailActivity.getDetailIntent(book, ArchiveActivity.this));
            }
        });
    }
}
