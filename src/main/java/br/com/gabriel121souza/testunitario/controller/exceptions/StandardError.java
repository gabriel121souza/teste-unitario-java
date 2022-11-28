package br.com.gabriel121souza.testunitario.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
public class StandardError {
    private LocalDateTime timeStamp;
    private Integer status;
    private String error;
    private String path;


}
