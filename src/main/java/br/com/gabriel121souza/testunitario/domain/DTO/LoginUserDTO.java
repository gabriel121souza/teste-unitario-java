package br.com.gabriel121souza.testunitario.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserDTO {
    private Integer id;
    private String name;
    private String email;
    private String password;
}