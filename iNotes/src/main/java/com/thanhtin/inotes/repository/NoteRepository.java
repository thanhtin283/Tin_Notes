package com.thanhtin.inotes.repository;

import com.thanhtin.inotes.model.Note;
import com.thanhtin.inotes.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteRepository extends PagingAndSortingRepository<Note,Long> {
    Iterable<Note> findAllByType(Type type);

    Page<Note> findAllByContentContaining(String count, Pageable pageable);
}
