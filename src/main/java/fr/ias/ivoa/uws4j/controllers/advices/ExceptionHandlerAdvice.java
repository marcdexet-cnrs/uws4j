package fr.ias.ivoa.uws4j.controllers.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import fr.ias.ivoa.uws4j.exceptions.NotFoundException;
import fr.ias.ivoa.uws4j.exceptions.PublicFailureRepresentation;

@ControllerAdvice(annotations=RestController.class)
public class ExceptionHandlerAdvice {
	
	@ExceptionHandler(value= {NotFoundException.class})
	public ResponseEntity<PublicFailureRepresentation> onNotFound(NotFoundException e) {
		PublicFailureRepresentation pfr = new PublicFailureRepresentation(e.getMessage(), e, showCase());
		return new ResponseEntity<PublicFailureRepresentation>(pfr, HttpStatus.NOT_FOUND);
	}

	private boolean showCase() {
		return true;
	}

}
