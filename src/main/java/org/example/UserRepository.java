package org.example;

import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> findById(Long id);
}
