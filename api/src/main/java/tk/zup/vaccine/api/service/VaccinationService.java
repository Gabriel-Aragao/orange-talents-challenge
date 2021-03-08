package tk.zup.vaccine.api.service;


import java.sql.SQLDataException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.zup.vaccine.api.model.User;
import tk.zup.vaccine.api.model.Vaccination;
import tk.zup.vaccine.api.model.dto.VaccinationDTO;
import tk.zup.vaccine.api.model.dto.VaccinationResponseDTO;
import tk.zup.vaccine.api.repository.VaccinationRepository;

@Service
public class VaccinationService {
  
  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private VaccinationRepository vaccinationRepository;

  @Autowired
  private UserService userService;

  public VaccinationResponseDTO save(VaccinationDTO vaccinationDTO) throws SQLDataException{
    Vaccination vaccination = modelMapper.map(vaccinationDTO, Vaccination.class);

    User user = userService.findById(vaccinationDTO.getUserId()).orElseThrow(
      () -> new SQLDataException("User Id Not finded in database")
    );

    vaccination.setUser(user);
 

    Vaccination savedVaccination = vaccinationRepository.save(vaccination);
    
    VaccinationResponseDTO vaccinationResponseDTO = modelMapper
      .map(savedVaccination, VaccinationResponseDTO.class);
    return vaccinationResponseDTO;
  }

}
