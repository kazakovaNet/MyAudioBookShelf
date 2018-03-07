package ru.kazakova_net.myaudiobookshelf.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ru.kazakova_net.myaudiobookshelf.R;
import ru.kazakova_net.myaudiobookshelf.model.AudioBook;

public class AudioBookAdapter extends ArrayAdapter<AudioBook> {
    private static final String TAG = "MyLog - " + AudioBook.class.getSimpleName();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param books   A List of AudioBooks objects to display in a list
     */
    public AudioBookAdapter(@NonNull Activity context, @NonNull ArrayList<AudioBook> books) {
        super(context, 0, books);

        Log.d(TAG, "create new adapter");
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position     The position in the list of data that should be displayed in the
     *                     list item view.
     * @param listItemView The recycled view to populate.
     * @param parent       The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View listItemView, @NonNull ViewGroup parent) {

        if (listItemView == null) {
            Log.d(TAG, "inflate new view");

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,
                    false);
        }

        AudioBook book = getItem(position);

        TextView titleTextView = listItemView.findViewById(R.id.title_text_view);
        if (book != null) {
            titleTextView.setText(book.getTitle());
        }

        TextView authorTextView = listItemView.findViewById(R.id.author_text_view);
        if (book != null) {
            authorTextView.setText(book.getAuthor());
        }

        ImageView pictureImageView = listItemView.findViewById(R.id.picture_image_view);
        if (book != null) {
            pictureImageView.setImageResource(book.getImageResourceId());
        }

        if (book != null) {
            Log.d(TAG, "getView: title = " + book.getTitle());
        }

        return listItemView;
    }
}
