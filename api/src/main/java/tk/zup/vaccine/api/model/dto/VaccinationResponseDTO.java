package tk.zup.vaccine.api.model.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class VaccinationResponseDTO {
  
  private Long id;
  private String vaccineName;
  private String userName;
  private String userCPF;
  private String userEmail;
  private LocalDate vaccinationDate;
}
