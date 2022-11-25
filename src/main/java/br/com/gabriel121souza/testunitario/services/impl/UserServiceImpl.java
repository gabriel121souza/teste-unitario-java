package br.com.gabriel121souza.testunitario.services.impl;

import br.com.gabriel121souza.testunitario.domain.LoginUser;
import br.com.gabriel121souza.testunitario.repository.UserRepository;
import br.com.gabriel121souza.testunitario.services.UserService;
import br.com.gabriel121souza.testunitario.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public LoginUser findById(Integer id) {
        Optional<LoginUser> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
