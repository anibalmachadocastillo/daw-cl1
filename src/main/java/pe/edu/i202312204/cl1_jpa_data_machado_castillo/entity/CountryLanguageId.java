package pe.edu.i202312204.cl1_jpa_data_machado_castillo.entity;

import java.io.Serializable;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryLanguageId implements Serializable {
    private String countryCode;
    private String language;
}
