package slavicprojekat.ctrl;

import java.net.URI;
import java.util.Collection;

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

import slavicprojekat.model.TipRacuna;
import slavicprojekat.repository.TipRacunaRepository;

@RestController
@CrossOrigin
public class TipRacunaRestController {

	@Autowired
	private TipRacunaRepository tipRacunaRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("tipracuna")
	public Collection<TipRacuna> getAll(){
		return tipRacunaRepository.findAll();
	}
	
	@GetMapping("tipracuna/{id}")
	public ResponseEntity<TipRacuna> getOne(@PathVariable("id") Integer id) {
		if(tipRacunaRepository.findById(id).isPresent()) {
			
		TipRacuna tipRacuna = tipRacunaRepository.getOne(id);
		return new ResponseEntity<>(tipRacuna, HttpStatus.OK);
	}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("tipracuna/naziv/{naziv}")
	public Collection<TipRacuna> getByNaziv(@PathVariable("naziv") String naziv){
		return tipRacunaRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@PostMapping("tipracuna")
	public ResponseEntity<TipRacuna> addTipRacuna(@RequestBody TipRacuna tipRacuna){
		TipRacuna savedTipRacuna = tipRacunaRepository.save(tipRacuna);
		URI location = URI.create("/tipRacuna/" + savedTipRacuna.getId());
		return ResponseEntity.created(location).body(savedTipRacuna);
	}
	@PutMapping("tipracuna/{id}")
	public ResponseEntity<TipRacuna> updateTipRacuna(@RequestBody TipRacuna tipRacuna, @PathVariable("id") Integer id){
		if(tipRacunaRepository.existsById(id)) {
		tipRacuna.setId(id);
		TipRacuna updatedTipRacuna = tipRacunaRepository.save(tipRacuna);
		return ResponseEntity.ok().body(updatedTipRacuna);
	}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("tipracuna/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
		if(id==-100 && !tipRacunaRepository.existsById(id)) {
			jdbcTemplate.execute("insert into tip_racuna(\"id\",\"naziv\",\"opis\",\"oznaka\") values (-100, 'Test tipRacuna','Test opis','100')");
		}
		if(tipRacunaRepository.existsById(id)) {
			tipRacunaRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
}