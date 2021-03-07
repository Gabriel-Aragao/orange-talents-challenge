package tk.zup.vaccine.api.model.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserDTO {
  
  private String name;
  private String email;
  private String cpf;
  private LocalDate birthday;

}
