package tk.zup.vaccine.api.resource;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tk.zup.vaccine.api.model.User;
import tk.zup.vaccine.api.model.Vaccination;
import tk.zup.vaccine.api.model.dto.UserDTO;
import tk.zup.vaccine.api.model.dto.UserResponseDTO;
import tk.zup.vaccine.api.service.UserService;

@RestController
public class UserResource {
  
  @Autowired
  private UserService userService;

  @Autowired
  private ModelMapper modelMapper;

  @PostMapping(path = "/users")
  public ResponseEntity<UserResponseDTO> create(@RequestBody UserDTO userDTO){
    

    User user = modelMapper.map(userDTO, User.class);
    user.setVaccinations(new ArrayList<Vaccination>());
    User savedUser = userService.save(user);
    
    UserResponseDTO userResponseDTO = modelMapper.map(savedUser, UserResponseDTO.class);
    
    return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
  }
}
