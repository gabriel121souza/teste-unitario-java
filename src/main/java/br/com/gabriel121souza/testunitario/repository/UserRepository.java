package br.com.gabriel121souza.testunitario.repository;

import br.com.gabriel121souza.testunitario.domain.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<LoginUser, Integer> {
    Optional<LoginUser> findByEmail(String email);

}
