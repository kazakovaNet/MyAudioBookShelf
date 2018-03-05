package ru.kazakova_net.myaudiobookshelf.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ru.kazakova_net.myaudiobookshelf.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyLog - " + MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate");

        setContentView(R.layout.activity_main);

        Button currentlyListeningBtn = findViewById(R.id.currently_listening_button);
        currentlyListeningBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onCurrentlyListeningBtnClick");

                Intent currentlyListeningIntent = new Intent(
                        MainActivity.this, CurrentlyListeningActivity.class);
                startActivity(currentlyListeningIntent);
            }
        });

        Button shelvedBtn = findViewById(R.id.shelved_button);
        shelvedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onShelvedBtnClick");

                Intent shelvedIntent = new Intent(
                        MainActivity.this, ShelvedActivity.class);
                startActivity(shelvedIntent);
            }
        });

        Button archiveBtn = findViewById(R.id.archive_button);
        archiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onArchiveBtnClick");

                Intent archiveIntent = new Intent(MainActivity.this, ArchiveActivity.class);
                startActivity(archiveIntent);
            }
        });
    }
}
