package tk.zup.vaccine.api.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  @Column(unique=true)
  private String email;
  @Column(unique=true)
  private String cpf;
  private LocalDate birthday;
  
  @OneToMany(mappedBy = "user")
  private List<Vaccination> vaccinations;

}
