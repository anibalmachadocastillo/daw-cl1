package pe.edu.i202312204.cl1_jpa_data_machado_castillo.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.i202312204.cl1_jpa_data_machado_castillo.entity.CountryLanguage;
import pe.edu.i202312204.cl1_jpa_data_machado_castillo.entity.CountryLanguageId;

public interface CountryLanguageRepository extends CrudRepository<CountryLanguage, CountryLanguageId> {
}
