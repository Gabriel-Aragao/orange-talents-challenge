package tk.zup.vaccine.api.model.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class VaccinationResponseDTO {
  
  private Long id;
  private String vaccineName;
  private String patientName;
  private String patientCPF;
  private String patientEmail;
  private LocalDate vaccinationDate;
}
