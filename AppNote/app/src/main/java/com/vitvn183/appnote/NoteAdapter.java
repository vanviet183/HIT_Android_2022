package com.vitvn183.appnote;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private MainActivity mContext;

    private List<Note> noteList;

    public NoteAdapter(MainActivity mContext, List<Note> noteList) {
        this.mContext = mContext;
        this.noteList = noteList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.note_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note = noteList.get(position);
        if(note == null) {
            return;
        }

        holder.titleNote.setText(note.getTitle());
        holder.content.setText(note.getContent());

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.editNote(note.getId(), note.getTitle(), note.getContent());
            }
        });

        holder.erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.deleteNote(note.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return noteList.isEmpty() ? 0 : noteList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleNote, content;
        ImageView edit, erase;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleNote = itemView.findViewById(R.id.title_note);
            content = itemView.findViewById(R.id.content);
            edit = itemView.findViewById(R.id.edit);
            erase = itemView.findViewById(R.id.erase);
        }
    }
}
