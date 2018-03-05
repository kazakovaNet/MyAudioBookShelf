package ru.kazakova_net.myaudiobookshelf.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import ru.kazakova_net.myaudiobookshelf.R;
import ru.kazakova_net.myaudiobookshelf.model.AudioBook;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "MyLog - " + DetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate");

        setContentView(R.layout.activity_detail);

        Intent detailIntent = getIntent();

        AudioBook book = detailIntent.getParcelableExtra(AudioBook.BOOK);

        ImageView pictureImageView = findViewById(R.id.picture_image_view);
        pictureImageView.setImageResource(book.getImageResourceId());

        TextView titleTextView = findViewById(R.id.title_text_view);
        titleTextView.setText(book.getTitle());

        TextView authorTextView = findViewById(R.id.author_text_view);
        authorTextView.setText(book.getAuthor());

        TextView genreTextView = findViewById(R.id.genre_text_view);
        genreTextView.setText(book.getGenre());

        TextView yearTextView = findViewById(R.id.year_text_view);
        yearTextView.setText(String.valueOf(book.getYear()));

        TextView descriptionTextView = findViewById(R.id.description_text_view);
        descriptionTextView.setText(book.getDescription());

        Button playButton = findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailActivity.this, "Audio-book start play!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
