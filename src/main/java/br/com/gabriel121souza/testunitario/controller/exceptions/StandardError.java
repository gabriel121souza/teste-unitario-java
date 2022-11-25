package br.com.gabriel121souza.testunitario.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {
    private LocalDateTime timeStamp;
    private Integer status;
    private String error;
    private String path;


}
