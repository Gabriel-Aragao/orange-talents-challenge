package tk.zup.vaccine.api.resource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tk.zup.vaccine.api.model.User;
import tk.zup.vaccine.api.model.Vaccination;
import tk.zup.vaccine.api.model.dto.VaccinationDTO;
import tk.zup.vaccine.api.model.dto.VaccinationResponseDTO;
import tk.zup.vaccine.api.service.UserService;
import tk.zup.vaccine.api.service.VaccinationService;

@RestController
public class VaccinationResource {
  
  @Autowired
  private VaccinationService vaccinationService;

  @Autowired
  private UserService userService;

  @Autowired
  private ModelMapper modelMapper;

  @PostMapping(path = "/vaccinations")
  public ResponseEntity<VaccinationResponseDTO> create(@RequestBody VaccinationDTO vaccinationDTO){
    try {
      Vaccination vaccination = modelMapper.map(vaccinationDTO, Vaccination.class);
      User user = userService.findById(vaccinationDTO.getPatientId()).orElseThrow();
      vaccination.setPatient(user);
      Vaccination savedVaccination = vaccinationService.save(vaccination);
      
      VaccinationResponseDTO vaccinationResponseDTO = modelMapper.map(savedVaccination, VaccinationResponseDTO.class);
      
      return ResponseEntity.status(HttpStatus.CREATED).body(vaccinationResponseDTO);
      
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new VaccinationResponseDTO());
    }
  }
}
