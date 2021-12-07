package slavicprojekat.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import slavicprojekat.model.Klijent;

public interface KlijentRepository extends JpaRepository<Klijent, Integer> {

	Collection <Klijent> findByPrezimeContainingIgnoreCase(String prezime);
}
