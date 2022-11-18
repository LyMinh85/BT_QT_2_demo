package com.example.bt_qt_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ListView listViewNotes;
    public static NotesAdapter notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Default Notes
        ArrayList<Note> listNotes = new ArrayList<>();
        listNotes.add(new Note("hello", new Date(), "Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello"));
        listNotes.add(new Note("World", new Date(), "YYYY"));

        // Adapter
        listViewNotes = findViewById(R.id.list_notes);
        notesAdapter = new NotesAdapter(this, listNotes);
        listViewNotes.setAdapter(notesAdapter);

        // Item click listener
        listViewNotes.setOnItemClickListener((adapterView, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, EditNoteActivity.class);
            Note note = notesAdapter.getItem(position);
            Bundle bundle = new Bundle();
            bundle.putInt("index", position);
            bundle.putString("title", note.getTitle());
            bundle.putString("content", note.getContent());
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.new_note) {
            Intent intent = new Intent(this, ActivityNewNote.class);
            startActivity(intent);
            notesAdapter.notifyDataSetChanged();
        }
        return true;
    }


}