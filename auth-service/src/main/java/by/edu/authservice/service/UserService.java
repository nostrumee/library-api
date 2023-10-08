package by.edu.authservice.service;

import by.edu.authservice.entity.User;

public interface UserService {

    User getById(Long id);

    User create(User user);

    User getByUsername(String username);
}
