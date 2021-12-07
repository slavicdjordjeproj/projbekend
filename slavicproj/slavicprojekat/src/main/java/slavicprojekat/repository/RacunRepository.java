package slavicprojekat.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import slavicprojekat.model.Klijent;
import slavicprojekat.model.Racun;

public interface RacunRepository  extends JpaRepository<Racun, Integer>{

	Collection <Racun> findByNazivContainingIgnoreCase(String naziv);
	Collection<Racun> findByKlijent(Klijent klijent);
}
