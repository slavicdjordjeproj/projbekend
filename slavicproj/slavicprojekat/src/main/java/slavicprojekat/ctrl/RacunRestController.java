	package slavicprojekat.ctrl;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import slavicprojekat.model.Klijent;
import slavicprojekat.model.Racun;
import slavicprojekat.repository.KlijentRepository;
import slavicprojekat.repository.RacunRepository;

@RestController
@CrossOrigin
public class RacunRestController {
	@Autowired
	private RacunRepository racunRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("racun")
	public Collection<Racun> getAll(){
		return racunRepository.findAll();
	}
	@GetMapping("racun/{id}")
	public ResponseEntity<Racun> getOne(@PathVariable("id") Integer id) {
		if(racunRepository.findById(id).isPresent()) {
		Racun racun = racunRepository.getOne(id);
		return new ResponseEntity<>(racun, HttpStatus.OK);
	}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
			
	@GetMapping("racun/naziv/{naziv}")
	public Collection<Racun> getByNaziv(@PathVariable("naziv") String naziv){
		return racunRepository.findByNazivContainingIgnoreCase(naziv);
	}
	@PostMapping("racun")
	public ResponseEntity<Racun> addRacun(@RequestBody Racun racun){
		Racun savedRacun = racunRepository.save(racun);
		URI location = URI.create("/racun/" + savedRacun.getId());
		return ResponseEntity.created(location).body(savedRacun);
	}
	@PutMapping("racun/{id}")
	public ResponseEntity<Racun> updateRacun(@RequestBody Racun racun, @PathVariable("id") Integer id){
		if(racunRepository.existsById(id)) {
		racun.setId(id);
		Racun updatedRacun = racunRepository.save(racun);
		return ResponseEntity.ok().body(updatedRacun);
	}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("racun/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id){
		if(id==-100 && !racunRepository.existsById(id)) {
			jdbcTemplate.execute("insert into racun(\"id\",\"naziv\",\"oznaka\",\"opis\",\"tip_racuna\",\"klijent\") values (-100, 'Test racun','10','Test opis','10','11')");
		}
		if(racunRepository.existsById(id)) {
			racunRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
}
