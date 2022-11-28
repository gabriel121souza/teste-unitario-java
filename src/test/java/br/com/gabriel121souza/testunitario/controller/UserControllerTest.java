package br.com.gabriel121souza.testunitario.controller;

import br.com.gabriel121souza.testunitario.domain.DTO.LoginUserDTO;
import br.com.gabriel121souza.testunitario.domain.LoginUser;
import br.com.gabriel121souza.testunitario.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    private static final Integer INDEX = 0;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startLoginUser();
    }

    @Test
    void whenFindindByIdThenReturnSuccess() {
        when(userService.findById(anyInt())).thenReturn(loginUser);
        when(mapper.map(any(), any())).thenReturn(loginUserDTO);
        ResponseEntity<LoginUserDTO> response = userController.findById(ID);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(LoginUserDTO.class, response.getBody().getClass());
        assertEquals(ID, response.getBody().getId());
        assertEquals(NAME, response.getBody().getName());
        assertEquals(EMAIL, response.getBody().getEmail());
        assertEquals(PASSWORD, response.getBody().getPassword());
    }

    @Test
    void whenFindAllThenReturnListOfLoginUserDTO() {
    when(userService.findAll()).thenReturn(List.of(loginUser));
    when(mapper.map(any(), any())).thenReturn(loginUserDTO);
    ResponseEntity<List<LoginUserDTO>> response = userController.findAll();

    assertNotNull(response);
    assertNotNull(response.getBody());

    assertEquals(ResponseEntity.class, response.getClass());
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(ArrayList.class, response.getBody().getClass());
    assertEquals(LoginUserDTO.class, response.getBody().get(INDEX).getClass());

        assertEquals(ID, response.getBody().get(INDEX).getId());
        assertEquals(NAME, response.getBody().get(INDEX).getName());
        assertEquals(EMAIL, response.getBody().get(INDEX).getEmail());
        assertEquals(PASSWORD, response.getBody().get(INDEX).getPassword());

    }

    @Test
    void whenCreateThenReturnCreated() {
        when(userService.create(any())).thenReturn(loginUser);

        ResponseEntity<LoginUserDTO> response = userController.create(loginUserDTO);
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getHeaders().get("Location"));


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