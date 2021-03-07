package tk.zup.vaccine.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tk.zup.vaccine.api.model.Vaccination;

public interface VaccinationRepository extends JpaRepository<Vaccination, Long>{
  
}
