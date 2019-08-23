package com.thanhtin.inotes.service;

import com.thanhtin.inotes.model.Note;
import com.thanhtin.inotes.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface NoteService {

    Page<Note> findAll(Pageable pageable);

    Note findById(Long id);

    void save(Note note);

    void remove(Long id);

    Iterable<Note> findAllByType(Type type);

    Page<Note> findAllByContentContaining(String count, Pageable pageable);
}
