package br.com.gabriel121souza.testunitario.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDTO {
    private Integer id;
    private String name;
    private String email;
    private String password;
}