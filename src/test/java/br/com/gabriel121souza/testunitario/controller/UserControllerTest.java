package br.com.gabriel121souza.testunitario.controller;

import br.com.gabriel121souza.testunitario.domain.DTO.LoginUserDTO;
import br.com.gabriel121souza.testunitario.domain.LoginUser;
import br.com.gabriel121souza.testunitario.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Mock
    private ModelMapper mapper;


    private LoginUser loginUser;
    private LoginUserDTO loginUserDTO;
    private static final Integer ID = 1;
    private static final String NAME = "Gabriel";
    private static final String EMAIL = "Gabriel121souza@gmail.com";
    private static final String PASSWORD = "123456";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startLoginUser();
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startLoginUser(){
        loginUser= new LoginUser(ID, NAME, EMAIL, PASSWORD);
        loginUserDTO= new LoginUserDTO(ID, NAME, EMAIL, PASSWORD);
    }
}