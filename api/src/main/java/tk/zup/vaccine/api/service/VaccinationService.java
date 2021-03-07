package tk.zup.vaccine.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.zup.vaccine.api.model.Vaccination;
import tk.zup.vaccine.api.repository.VaccinationRepository;

@Service
public class VaccinationService {
  
  @Autowired
  private VaccinationRepository vaccinationRepository;

  public Vaccination save(Vaccination vaccination){
    return vaccinationRepository.save(vaccination);
  }

}
