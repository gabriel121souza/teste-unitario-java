package br.com.gabriel121souza.testunitario.config;

import br.com.gabriel121souza.testunitario.domain.LoginUser;
import br.com.gabriel121souza.testunitario.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean
    public void startDB() {
        LoginUser u1 = new LoginUser(null, "Valdir", "valdir@mail.com", "123");
        LoginUser u2 = new LoginUser(null, "Luiz", "luiz@mail.com", "123");

        repository.saveAll(List.of(u1, u2));
    }
}
