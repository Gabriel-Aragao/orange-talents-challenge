package tk.zup.vaccine.api.model.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class UserResponseDTO {

  private Long id;
  private String name;
  private String email;
  private String cpf;
  private LocalDate birthday;
  private List<VaccinationListDTO> vaccinations;
  
}
