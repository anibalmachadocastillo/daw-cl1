package pe.edu.i202312204.cl1_jpa_data_machado_castillo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(CountryLanguageId.class)
public class CountryLanguage {

    @Id
    private String countryCode;
    @Id
    private String language;
    private Boolean isOfficial;
    private Double percentage;


    @ManyToOne
    @JoinColumn(name = "CountryCode", insertable = false, updatable = false)
    @ToString.Exclude
    private Country country;

}
