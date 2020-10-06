package com.mojos.userservice.repository;

import com.mojos.userservice.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUserId(String id);
    Optional<User> findByEmail(String email);

    void deleteByUserId(String userId);
}