package br.com.gabriel121souza.testunitario.controller.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import br.com.gabriel121souza.testunitario.services.exceptions.ObjectNotFoundException;

@SpringBootTest
class ControllerExceptionHandlerTest {

	private static final String MSG_OBJECT_NOT_FOUND = "Objeto não encontrado";
	
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
		
		
	}

	@Test
	void testDataIntegrityViolationException() {
		fail("Not yet implemented");
	}

}
