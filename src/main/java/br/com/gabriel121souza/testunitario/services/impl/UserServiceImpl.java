package br.com.gabriel121souza.testunitario.services.impl;

import br.com.gabriel121souza.testunitario.domain.DTO.LoginUserDTO;
import br.com.gabriel121souza.testunitario.domain.LoginUser;
import br.com.gabriel121souza.testunitario.repository.UserRepository;
import br.com.gabriel121souza.testunitario.services.DataIntegratyViolationException;
import br.com.gabriel121souza.testunitario.services.UserService;
import br.com.gabriel121souza.testunitario.services.exceptions.ObjectNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public LoginUser findById(Integer id) {
        Optional<LoginUser> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
    public List<LoginUser> findAll() {
        return userRepository.findAll();
    }

    public LoginUser create(LoginUserDTO obj) {
        findByEmail(obj);
        return userRepository.save(mapper.map(obj, LoginUser.class));
    }

    private void findByEmail(LoginUserDTO obj) {
        Optional<LoginUser> user = userRepository.findByEmail(obj.getEmail());
        if(user.isPresent() && !user.get().getId().equals(obj.getId())) {
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
        }
    }
    @Override
    public LoginUser update(LoginUserDTO obj) {
        findByEmail(obj);
        return userRepository.save(mapper.map(obj, LoginUser.class));
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        userRepository.deleteById(id);
    }
}