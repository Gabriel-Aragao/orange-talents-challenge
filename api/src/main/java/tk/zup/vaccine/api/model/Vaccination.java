package tk.zup.vaccine.api.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "vaccination")
public class Vaccination {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String vaccineName;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;
  private LocalDate vaccinationDate;
}
