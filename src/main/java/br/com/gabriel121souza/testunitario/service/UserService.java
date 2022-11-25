package br.com.gabriel121souza.testunitario.service;

import br.com.gabriel121souza.testunitario.domain.User;

public interface UserService {
    User findById(Integer id);
}
