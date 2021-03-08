package tk.zup.vaccine.api.resource;



import java.sql.SQLDataException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tk.zup.vaccine.api.model.dto.VaccinationDTO;
import tk.zup.vaccine.api.model.dto.VaccinationResponseDTO;
import tk.zup.vaccine.api.service.VaccinationService;

@RestController
public class VaccinationResource {
  
  @Autowired
  private VaccinationService vaccinationService;

  @PostMapping(path = "/vaccinations")
  public ResponseEntity<VaccinationResponseDTO> create(@Valid @RequestBody VaccinationDTO vaccinationDTO) throws SQLDataException{
    
    VaccinationResponseDTO vaccinationResponseDTO = vaccinationService.save(vaccinationDTO);
    
    return ResponseEntity.status(HttpStatus.CREATED).body(vaccinationResponseDTO);  
  }


}
