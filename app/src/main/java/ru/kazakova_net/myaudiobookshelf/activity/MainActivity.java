package ru.kazakova_net.myaudiobookshelf.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import ru.kazakova_net.myaudiobookshelf.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MyLog - " + MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate");

        setContentView(R.layout.activity_main);

        RelativeLayout currentlyListeningTextView = findViewById(R.id.currently_listening_item);
        currentlyListeningTextView.setOnClickListener(this);

        RelativeLayout shelvedTextView = findViewById(R.id.shelved_item);
        shelvedTextView.setOnClickListener(this);

        RelativeLayout archiveTextView = findViewById(R.id.archive_item);
        archiveTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.currently_listening_item:
                Log.d(TAG, "onCurrentlyListeningBtnClick");

                Intent currentlyListeningIntent = new Intent(
                        MainActivity.this, CurrentlyListeningActivity.class);
                startActivity(currentlyListeningIntent);
                break;
            case R.id.shelved_item:
                Log.d(TAG, "onShelvedBtnClick");

                Intent shelvedIntent = new Intent(
                        MainActivity.this, ShelvedActivity.class);
                startActivity(shelvedIntent);
                break;
            case R.id.archive_item:
                Log.d(TAG, "onArchiveBtnClick");

                Intent archiveIntent = new Intent(MainActivity.this, ArchiveActivity.class);
                startActivity(archiveIntent);
                break;
        }
    }
}
