package tk.zup.vaccine.api.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Data
public class UserDTO {
  
  @NotBlank
  private String name;
  @NotBlank
  @Email
  private String email;
  @NotBlank
  @CPF
  private String cpf;
  private LocalDate birthday;

}
