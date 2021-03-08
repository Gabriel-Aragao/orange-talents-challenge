package tk.zup.vaccine.api.service;

import java.util.ArrayList;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.zup.vaccine.api.model.User;
import tk.zup.vaccine.api.model.Vaccination;
import tk.zup.vaccine.api.model.dto.UserDTO;
import tk.zup.vaccine.api.model.dto.UserResponseDTO;
import tk.zup.vaccine.api.repository.UserRepository;

@Service
public class UserService {
  
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ModelMapper modelMapper;

  public UserResponseDTO save(UserDTO userDTO){

    User user = modelMapper.map(userDTO, User.class);
    user.setVaccinations(new ArrayList<Vaccination>());
    User savedUser = userRepository.save(user);
    UserResponseDTO userResponseDTO = modelMapper.map(savedUser, UserResponseDTO.class);

    return userResponseDTO;
  }

  public Optional<User> findById(Long id){
    return userRepository.findById(id);
  }

}
