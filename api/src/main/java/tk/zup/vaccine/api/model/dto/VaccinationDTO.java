package tk.zup.vaccine.api.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class VaccinationDTO {
  
  @NotBlank
  private String vaccineName;
  @NotNull
  private Long userId;

  @NotNull
  private LocalDate vaccinationDate;
  
}
