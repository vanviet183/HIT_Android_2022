package com.vitvn183.appnote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Database database;
    List<Note> noteList = new ArrayList<>();
    NoteAdapter noteAdapter;
    RecyclerView recyclerView;
    RelativeLayout add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.note_list);

//        NoteAdapter noteAdapter = new NoteAdapter(this, noteList);
//        recyclerView.setAdapter(noteAdapter);

        database = new Database(this, "Note.sqlite", null, 1);

        database.QueryData("CREATE TABLE IF NOT EXISTS Note(id INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR, content VARCHAR)");

        getData();

        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNote();
            }
        });
    }

    public void addNote() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.add_note);

        EditText addTitle, addContent;
        Button addNew;
        RelativeLayout back;

        addTitle = dialog.findViewById(R.id.add_title);
        addContent = dialog.findViewById(R.id.add_content);
        addNew = dialog.findViewById(R.id.addNew);
        back = dialog.findViewById(R.id.back);

        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = addTitle.getText().toString();
                String content = addContent.getText().toString();

                if (title == "") {
                    Toast.makeText(MainActivity.this, "Please enter your note", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else {
                    database.QueryData("INSERT INTO Note VALUES(null, '"+ title +"', '"+ content +"')");
                    dialog.dismiss();
                    getData();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void editNote(int id, String title, String content) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.edit_note);

        EditText editTitle = dialog.findViewById(R.id.edit_title);
        EditText editContent = dialog.findViewById(R.id.edit_content);
        Button confirm = dialog.findViewById(R.id.confirm);
        RelativeLayout back = dialog.findViewById(R.id.back);

        editTitle.setText(title);
        editContent.setText(content);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titleNew = editTitle.getText().toString().trim();
                String contentNew = editContent.getText().toString().trim();
                database.QueryData("UPDATE NOTE SET title = '"+ titleNew +"', content = '"+ contentNew +"'  WHERE id='"+ id +"'");
                Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                getData();
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void deleteNote(int id){
        AlertDialog.Builder eraseDialog = new AlertDialog.Builder(this);
        eraseDialog.setMessage("Are you sure you want to delete?");
        eraseDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                database.QueryData("DELETE FROM Note WHERE id='"+id+"'");
                getData();
            }
        });
        eraseDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        eraseDialog.show();
    }

    private void getData() {
        // select data
        Cursor dataNote = database.GetData("Select * From Note");
        noteList.clear();
        while (dataNote.moveToNext()) {
            String title = dataNote.getString(1);
            String content = dataNote.getString(2);
            int id = dataNote.getInt(0);
            noteList.add((new Note(id, title, content)));
        }
        noteAdapter = new NoteAdapter(this, noteList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setAdapter(noteAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}