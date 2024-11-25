package pe.edu.i202312204.cl1_jpa_data_machado_castillo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pe.edu.i202312204.cl1_jpa_data_machado_castillo.entity.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
}
