package tk.zup.vaccine.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tk.zup.vaccine.api.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
  
}
