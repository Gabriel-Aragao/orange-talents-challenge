package tk.zup.vaccine.api.model.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class VaccinationListDTO {
  
  private String vaccineName;
  private LocalDate vaccinationDate;
}
