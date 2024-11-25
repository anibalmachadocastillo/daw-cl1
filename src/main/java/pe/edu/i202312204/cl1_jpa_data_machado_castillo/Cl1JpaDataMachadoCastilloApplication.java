package pe.edu.i202312204.cl1_jpa_data_machado_castillo;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202312204.cl1_jpa_data_machado_castillo.entity.Country;
import pe.edu.i202312204.cl1_jpa_data_machado_castillo.entity.CountryLanguage;
import pe.edu.i202312204.cl1_jpa_data_machado_castillo.repository.CountryRepository;

import java.beans.Customizer;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Cl1JpaDataMachadoCastilloApplication implements CommandLineRunner {

	@Autowired
	CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataMachadoCastilloApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

	consultar();

	}
	private void consultar() {
		Optional<Country> optionalArg = countryRepository.findById("ARG");
		optionalArg.ifPresentOrElse(country -> {
			System.out.println("En argentina hablan : " + country.getName());
			country.getCountryLanguageList().forEach(language ->{
					System.out.println(language.getLanguage());
					}

			);
			eliminarARGAndCOL();
		}, () -> {
			System.out.println("Country ARG not found.");
			countryRepository.findById("PER").ifPresent(perCountry ->
					perCountry.getCountryLanguageList().forEach(language ->
							System.out.println(language.getLanguage())
					)
			);
		});
	}

	private void eliminarARGAndCOL() {
		countryRepository.deleteAllById(List.of("COL", "ARG"));
		countryRepository.flush();
		System.out.println("Países COL y ARG eliminados con cascada.");
		consultar();
	}

}
