package tk.zup.vaccine.api.resource;


import java.util.Optional;


import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
  public ResponseEntity<VaccinationResponseDTO> create(@Valid @RequestBody VaccinationDTO vaccinationDTO) throws Exception{
    Vaccination vaccination = modelMapper.map(vaccinationDTO, Vaccination.class);

    Optional<User> user = userService.findById(vaccinationDTO.getPatientId());
    if(user.isPresent()){
      vaccination.setPatient(user.get());
    } else {
      throw new Exception("There`s no Patient in our database with the referred Id");
    }

    Vaccination savedVaccination = vaccinationService.save(vaccination);
    
    VaccinationResponseDTO vaccinationResponseDTO = modelMapper
      .map(savedVaccination, VaccinationResponseDTO.class);
      
      return ResponseEntity.status(HttpStatus.CREATED).body(vaccinationResponseDTO);
      
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleValidationExceptions(Exception e){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
      .body(e.getMessage());
  }
}
