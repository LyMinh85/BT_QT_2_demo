package com.example.bt_qt_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Date;

public class EditNoteActivity extends AppCompatActivity {
    private TextView editNoteTitleTV;
    private TextView editNoteContentTV;
    private int noteIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        Bundle bundle = getIntent().getExtras();
        noteIndex = bundle.getInt("index");
        String title = bundle.getString("title");
        String content = bundle.getString("content");

        editNoteTitleTV = findViewById(R.id.edit_note_title);
        editNoteContentTV = findViewById(R.id.edit_note_content);

        editNoteTitleTV.setText(title);
        editNoteContentTV.setText(content);
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
            TextView editNoteTitleTV = findViewById(R.id.edit_note_title);
            TextView editNoteContentTV = findViewById(R.id.edit_note_content);
            String title = editNoteTitleTV.getText().toString();
            String content = editNoteContentTV.getText().toString();
            if (title.isEmpty()) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                alertDialog.setMessage("Title is empty");
                alertDialog.show();
                return false;
            }
            if (content.isEmpty()) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                alertDialog.setMessage("Content is empty");
                alertDialog.show();
                return false;
            }
            Note note = new Note(title, new Date(), content);
            Log.v("Test", String.valueOf(noteIndex), new Throwable());
            MainActivity.notesAdapter.set(noteIndex, note);
            MainActivity.notesAdapter.notifyDataSetChanged();
            setResult(Activity.RESULT_OK);
            finish();
        } else if (item.getItemId() == R.id.delete_note) {
            MainActivity.notesAdapter.remove(noteIndex);
            MainActivity.notesAdapter.notifyDataSetChanged();
            finish();
        }

        return true;
    }
}