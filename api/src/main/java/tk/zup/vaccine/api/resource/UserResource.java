package tk.zup.vaccine.api.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tk.zup.vaccine.api.model.dto.UserDTO;
import tk.zup.vaccine.api.model.dto.UserResponseDTO;
import tk.zup.vaccine.api.service.UserService;

@RestController
public class UserResource {
  
  @Autowired
  private UserService userService;

  @PostMapping(path = "/users")
  public ResponseEntity<UserResponseDTO> create(@Valid @RequestBody UserDTO userDTO){
    
    UserResponseDTO userResponseDTO = userService.save(userDTO);
    
    return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
      
  }
}
