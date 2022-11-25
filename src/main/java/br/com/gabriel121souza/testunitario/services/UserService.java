package br.com.gabriel121souza.testunitario.services;

import br.com.gabriel121souza.testunitario.domain.DTO.LoginUserDTO;
import br.com.gabriel121souza.testunitario.domain.LoginUser;

import java.util.Arrays;
import java.util.List;

public interface UserService {
    LoginUser findById(Integer id);
    List<LoginUser> findAll();
    LoginUser create(LoginUserDTO obj);

}
