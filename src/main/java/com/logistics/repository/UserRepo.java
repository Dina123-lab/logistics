package com.logistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.logistics.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    Optional<User> findByMobile(String mobile);



}

