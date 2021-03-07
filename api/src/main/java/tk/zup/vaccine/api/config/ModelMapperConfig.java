package tk.zup.vaccine.api.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tk.zup.vaccine.api.model.Vaccination;
import tk.zup.vaccine.api.model.dto.VaccinationDTO;



@Configuration
public class ModelMapperConfig {
  
  @Bean
  public ModelMapper modelMapper(){
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration()
    .setFieldMatchingEnabled(true)
    .setFieldAccessLevel(AccessLevel.PACKAGE_PRIVATE);

    TypeMap<VaccinationDTO,Vaccination> vaccinationTypeMap;
    vaccinationTypeMap = modelMapper.createTypeMap(VaccinationDTO.class, Vaccination.class);
    vaccinationTypeMap.addMappings(mapper -> mapper.skip(Vaccination::setId));
    return modelMapper;
  }
}
