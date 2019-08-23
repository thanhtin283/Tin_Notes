package com.thanhtin.inotes.service.impl;

import com.thanhtin.inotes.model.Note;
import com.thanhtin.inotes.model.Type;
import com.thanhtin.inotes.repository.NoteRepository;
import com.thanhtin.inotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class NoteServiecImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Page<Note> findAll(Pageable pageable) {
        pageable=new PageRequest(pageable.getPageNumber (), 5);
        return noteRepository.findAll(pageable);
    }

    @Override
    public Note findById(Long id) {
        return noteRepository.findOne(id);
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);

    }

    @Override
    public void remove(Long id) {
        noteRepository.delete(id);

    }

    @Override
    public Iterable<Note> findAllByType(Type type) {
        return noteRepository.findAllByType(type);
    }

    @Override
    public Page<Note> findAllByContentContaining(String count, Pageable pageable) {
        return noteRepository.findAllByContentContaining(count,pageable);
    }
}
