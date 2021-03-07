package tk.zup.vaccine.api.model.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class VaccinationDTO {
  
  private String vaccineName;
  private Long patientId;
  private LocalDate vaccinationDate;
  
}
