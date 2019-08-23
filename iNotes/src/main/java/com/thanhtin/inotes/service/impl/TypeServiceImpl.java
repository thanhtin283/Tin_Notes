package com.thanhtin.inotes.service.impl;

import com.thanhtin.inotes.model.Type;
import com.thanhtin.inotes.repository.TypeRepository;
import com.thanhtin.inotes.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;

public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Iterable<Type> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public Type findById(Long id) {
        return typeRepository.findOne(id);
    }

    @Override
    public void save(Type type) {
    typeRepository.save(type);
    }

    @Override
    public void remove(Long id) {
    typeRepository.delete(id);
    }
}
