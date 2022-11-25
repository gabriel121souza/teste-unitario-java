package br.com.gabriel121souza.testunitario.service.impl;

import br.com.gabriel121souza.testunitario.domain.User;
import br.com.gabriel121souza.testunitario.repository.UserRepository;
import br.com.gabriel121souza.testunitario.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }
}
