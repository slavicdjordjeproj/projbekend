package slavicprojekat.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import slavicprojekat.model.Kredit;

public interface KreditRepository extends JpaRepository<Kredit, Integer> {

	
	Collection <Kredit> findByNazivContainingIgnoreCase(String naziv);
}
