package com.thanhtin.inotes.service;

import com.thanhtin.inotes.model.Type;

public interface TypeService {

    Iterable<Type>findAll();

    Type findById(Long id);

    void save(Type type);

    void remove(Long id);
}
