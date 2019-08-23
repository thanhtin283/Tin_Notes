package com.thanhtin.inotes.repository;

import com.thanhtin.inotes.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User,Long> {
    Iterable<User> findUserByName(User user);

    User findByName(String name);
}
