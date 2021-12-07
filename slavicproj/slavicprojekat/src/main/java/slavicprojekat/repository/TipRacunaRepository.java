package slavicprojekat.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import slavicprojekat.model.TipRacuna;

public interface TipRacunaRepository extends JpaRepository<TipRacuna, Integer>{
	
	Collection <TipRacuna> findByNazivContainingIgnoreCase(String naziv);
}
