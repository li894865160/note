package com.note.service.note;

import java.util.List;

import com.note.model.note.Note;

public interface NoteServices {

    Note add(Note note);
    
    Note update(Note note);
    
    List<Note> getAll();
    
    Note getById(int id);
}
