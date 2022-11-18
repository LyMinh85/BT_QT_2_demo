package com.example.bt_qt_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Date;

public class ActivityNewNote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.note_option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.save_note) {
            TextView newNoteTitleTV = findViewById(R.id.new_note_title);
            TextView newNoteContentTV = findViewById(R.id.new_note_content);
            String newNoteTitle = newNoteTitleTV.getText().toString();
            String newNoteContent = newNoteContentTV.getText().toString();
            if (newNoteTitle.isEmpty()) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                alertDialog.setMessage("Title is empty");
                alertDialog.show();
                return false;
            }
            if (newNoteContent.isEmpty()) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                alertDialog.setMessage("Content is empty");
                alertDialog.show();
                return false;
            }
            Note newNote = new Note(newNoteTitle, new Date(), newNoteContent);
            MainActivity.notesAdapter.add(newNote);
            setResult(Activity.RESULT_OK);
            finish();
        } else if (item.getItemId() == R.id.delete_note) {
            finish();
        }
        return true;
    }
}