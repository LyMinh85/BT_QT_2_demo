package com.example.bt_qt_2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class NotesAdapter extends ArrayAdapter<Note> {
    private ArrayList<Note> listNotes = new ArrayList<>();
    public NotesAdapter(Context context, ArrayList<Note> notes) {
        super(context, 0, notes);
        listNotes = notes;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Note note = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.note_item, parent, false);
        }
        TextView title = convertView.findViewById(R.id.note_title);
        TextView date = convertView.findViewById(R.id.note_date);
        TextView content = convertView.findViewById(R.id.note_content);
        String contentSubstring = note.getContent();
        if (note.getContent().length() > 50) {
            contentSubstring = note.getContent().substring(0, 50) + "...";
        }
        title.setText(note.getTitle());
        date.setText(note.getDateFormat());
        content.setText(contentSubstring);
        return convertView;
    }

    public void set(int index, Note note) {
        listNotes.set(index, note);
    }

    public void remove(int index) {
        listNotes.remove(index);
    }
}
