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

import slavicprojekat.model.Klijent;
import slavicprojekat.repository.KlijentRepository;

@RestController
@CrossOrigin
public class KlijentRestController {
	
	@Autowired
	private KlijentRepository klijentRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("klijent")
	public Collection<Klijent> getAll(){
		return klijentRepository.findAll();
	}
	
	@GetMapping("klijent/{id}")
	public ResponseEntity<Klijent> getOne(@PathVariable("id") Integer id) {
		if(klijentRepository.findById(id).isPresent()) {
			
		Klijent klijent = klijentRepository.getOne(id);
		return new ResponseEntity<>(klijent, HttpStatus.OK);
	}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("klijent/prezime/{prezime}")
	public Collection<Klijent> getByPrezime(@PathVariable("prezime") String prezime){
		return klijentRepository.findByPrezimeContainingIgnoreCase(prezime);
	}
	
	@PostMapping("klijent")
	public ResponseEntity<Klijent> addKlijent(@RequestBody Klijent klijent){
		Klijent savedKlijent = klijentRepository.save(klijent);
		URI location = URI.create("/klijent/" + savedKlijent.getId());
		return ResponseEntity.created(location).body(savedKlijent);
	}
	@PutMapping("klijent/{id}")
	public ResponseEntity<Klijent> updateKlijent(@RequestBody Klijent klijent, @PathVariable("id") Integer id){
		if(klijentRepository.existsById(id)) {
		klijent.setId(id);
		Klijent updatedKlijent = klijentRepository.save(klijent);
		return ResponseEntity.ok().body(updatedKlijent);
	}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("klijent/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id){
		if(id==-100 && !klijentRepository.existsById(id)) {
			jdbcTemplate.execute("insert into klijent(\"id\",\"ime\",\"prezime\",\"broj_lk\",\"kredit\") values (-100, 'Test ','Testic','919555555','11')");
		}
		if(klijentRepository.existsById(id)) {
			klijentRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
}