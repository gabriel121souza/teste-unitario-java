package br.com.gabriel121souza.testunitario.controller.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import br.com.gabriel121souza.testunitario.services.exceptions.DataIntegratyViolationException;
import br.com.gabriel121souza.testunitario.services.exceptions.ObjectNotFoundException;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ControllerExceptionHandlerTest {

	private static final String MSG_OBJECT_NOT_FOUND = "Objeto não encontrado";
	private static final String MSG_DATA_INTEGRITY_VIOLIOTION_EMAIL = "E-mail já cadastrado";
	
	
	@InjectMocks
	private ControllerExceptionHandler exceptionHandler;
	
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void whenObjectNotFoundExceptionThenReturnAResponseEntity() {
		ResponseEntity<StandardError> response = exceptionHandler
				.ObjectNotFound(new ObjectNotFoundException(MSG_OBJECT_NOT_FOUND), new MockHttpServletRequest());
		assertNotNull(response);
		assertNotNull(response.getBody());
		
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertEquals(ResponseEntity.class, response.getClass());
		assertEquals(StandardError.class, response.getBody().getClass());
		assertEquals(MSG_OBJECT_NOT_FOUND, response.getBody().getError());
		assertEquals(404, response.getBody().getStatus());
		assertNotEquals("/user/2", response.getBody().getPath());
		assertNotEquals(LocalDateTime.now(), response.getBody().getTimeStamp());
		
		
	}

	@Test
	void whenDataIntegrityViolationException() {
		ResponseEntity<StandardError> response = exceptionHandler
				.dataIntegrityViolationException(new DataIntegratyViolationException(MSG_DATA_INTEGRITY_VIOLIOTION_EMAIL), new MockHttpServletRequest());
		assertNotNull(response);
		assertNotNull(response.getBody());
		
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals(ResponseEntity.class, response.getClass());
		assertEquals(StandardError.class, response.getBody().getClass());
		assertEquals(MSG_DATA_INTEGRITY_VIOLIOTION_EMAIL, response.getBody().getError());
		assertEquals(400, response.getBody().getStatus());
		assertNotEquals("/user/2", response.getBody().getPath());
		assertNotEquals(LocalDateTime.now(), response.getBody().getTimeStamp());
	}

}
