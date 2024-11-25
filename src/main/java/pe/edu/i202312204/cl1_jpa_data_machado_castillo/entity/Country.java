package pe.edu.i202312204.cl1_jpa_data_machado_castillo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    private String code;
    private String name;
    private String continent;
    private String region;
    private BigDecimal surfaceArea;
    private Short indepYear;
    private Integer population;
    private BigDecimal lifeExpectancy;
    private BigDecimal gnp;
    private BigDecimal gnpOld;
    private String localName;
    private String governmentForm;
    private String headOfState;
    private Integer capital;
    private String code2;

    @OneToMany(mappedBy = "country",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true)
    @ToString.Exclude
    private List<City> cityList;

    @OneToMany(mappedBy = "country", cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true)
    @ToString.Exclude
    private List<CountryLanguage> countryLanguageList;

    public void addCity(City city) {
        cityList.add(city);
        city.setCountry(this);
    }

    public void removeCity(City city) {
        cityList.remove(city);
        city.setCountry(null);
    }

    public void addCountryLanguage(CountryLanguage countryLanguage) {
        countryLanguageList.add(countryLanguage);
        countryLanguage.setCountry(this);
    }

    public void removeCountryLanguage(CountryLanguage countryLanguage) {
        countryLanguageList.remove(countryLanguage);
        countryLanguage.setCountry(null);
    }

}
