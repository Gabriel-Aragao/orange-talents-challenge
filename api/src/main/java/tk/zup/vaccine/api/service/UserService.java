package tk.zup.vaccine.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.zup.vaccine.api.model.User;
import tk.zup.vaccine.api.repository.UserRepository;

@Service
public class UserService {
  
  @Autowired
  private UserRepository userRepository;

  public User save(User user){
    return userRepository.save(user);
  }

}
