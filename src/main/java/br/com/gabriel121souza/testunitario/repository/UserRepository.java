package br.com.gabriel121souza.testunitario.repository;

import br.com.gabriel121souza.testunitario.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Integer> {
}