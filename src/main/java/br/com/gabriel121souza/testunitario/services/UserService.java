package br.com.gabriel121souza.testunitario.services;

import br.com.gabriel121souza.testunitario.domain.LoginUser;

public interface UserService {
    LoginUser findById(Integer id);
}
