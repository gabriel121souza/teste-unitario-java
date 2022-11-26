package br.com.gabriel121souza.testunitario.services.impl;

import br.com.gabriel121souza.testunitario.domain.DTO.LoginUserDTO;
import br.com.gabriel121souza.testunitario.domain.LoginUser;
import br.com.gabriel121souza.testunitario.repository.UserRepository;
import br.com.gabriel121souza.testunitario.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.data.repository.support.Repositories;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {
    private static final Integer id = 1;
    private static final String name = "Gabriel";
    private static final String email = "Gabriel121souza@gmail.com";
    private static final String password = "123456";
    private static final String OBJECT_NOT_FOUND = "Objeto não encontrado";
    private static final Integer INDEX = 0;



    //cria uma instancia real
    @InjectMocks
    private UserServiceImpl service;
    @Mock //Mocka os dados pois nao precisamos de dados reais;
    private UserRepository userRepository;
    @Mock
    private ModelMapper mapper;
    private LoginUser loginUser;
    private LoginUserDTO loginUserDTO;
    private Optional<LoginUser> loginUserOptional;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startLoginUser();
    }

    @Test
    void whenFindByIdThenReturnAndUserInstance() {
        when(userRepository.findById(anyInt())).thenReturn(loginUserOptional);
        LoginUser response = service.findById(id);
        assertNotNull(response);
        assertEquals(LoginUser.class, response.getClass());
        assertEquals(id, response.getId());
        assertEquals(name, response.getName());
        assertEquals(email, response.getEmail());
        assertEquals(password, response.getPassword());


    }

    @Test
    void whenFindByIdThenReturnAndObjectNotFoundException(){
        when(userRepository.findById(anyInt())).thenThrow(new ObjectNotFoundException(OBJECT_NOT_FOUND));
        try{
            service.findById(id);
        }catch (Exception e){
            assertEquals(ObjectNotFoundException.class, e.getClass());
            assertEquals(OBJECT_NOT_FOUND, e.getMessage());
        }
    }

    @Test
    void whernFindAllReturnAnListOfUsers() {
    when(userRepository.findAll()).thenReturn(List.of(loginUser));
    List<LoginUser> responses = service.findAll();

    assertNotNull(responses);
    assertEquals(1, responses.size());
    assertEquals(LoginUser.class, responses.get(INDEX).getClass());

    assertEquals(id, responses.get(INDEX).getId());
    assertEquals(name, responses.get(INDEX).getName());
    assertEquals(email, responses.get(INDEX).getEmail());
    assertEquals(password, responses.get(INDEX).getPassword());

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
        loginUser= new LoginUser(id, name, email, password);
        loginUserDTO= new LoginUserDTO(id, name, email, password);
         loginUserOptional= Optional.of(new LoginUser(id, name, email, password));


    }
}