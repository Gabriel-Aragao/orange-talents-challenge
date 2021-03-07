package tk.zup.vaccine.api.resource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tk.zup.vaccine.api.model.Vaccination;
import tk.zup.vaccine.api.model.dto.VaccinationDTO;
import tk.zup.vaccine.api.model.dto.VaccinationResponseDTO;
import tk.zup.vaccine.api.service.VaccinationService;

@RestController
public class VaccinationResource {
  
  @Autowired
  private VaccinationService vaccinationService;

  @Autowired
  private ModelMapper modelMapper;

  @PostMapping(path = "/vaccinations")
  public ResponseEntity<VaccinationResponseDTO> create(@RequestBody VaccinationDTO vaccinationDTO){
    
    Vaccination vaccination = modelMapper.map(vaccinationDTO, Vaccination.class);
    
    Vaccination savedVaccination = vaccinationService.save(vaccination);
    
    VaccinationResponseDTO vaccinationResponseDTO = modelMapper.map(savedVaccination, VaccinationResponseDTO.class);
    
    return ResponseEntity.status(HttpStatus.CREATED).body(vaccinationResponseDTO);
  }
}
