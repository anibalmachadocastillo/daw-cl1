package pe.edu.i202312204.cl1_jpa_data_machado_castillo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String district;
    private int population;

    @ManyToOne
    @JoinColumn(name="CountryCode",referencedColumnName = "code")
    @ToString.Exclude
    private Country country;

}
