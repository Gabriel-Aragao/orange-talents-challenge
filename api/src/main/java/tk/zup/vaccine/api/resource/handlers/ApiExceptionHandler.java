package tk.zup.vaccine.api.resource.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
  

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleExceptions(Exception e){

    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
      .body(e.getMessage());
  }
  
}
