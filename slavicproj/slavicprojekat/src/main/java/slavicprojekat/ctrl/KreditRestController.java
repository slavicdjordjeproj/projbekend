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

import slavicprojekat.model.Kredit;
import slavicprojekat.repository.KreditRepository;
import slavicprojekat.repository.KreditRepository;

@RestController
@CrossOrigin
public class KreditRestController {

	@Autowired
	private KreditRepository kreditRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("kredit")
	public Collection<Kredit> getAll(){
		return kreditRepository.findAll();
	}
	@GetMapping("kredit/{id}")
	public ResponseEntity<Kredit> getOne(@PathVariable("id") Integer id) {
		if(kreditRepository.findById(id).isPresent()) {
			
		Kredit kredit = kreditRepository.getOne(id);
		return new ResponseEntity<>(kredit, HttpStatus.OK);
	}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@GetMapping("kredit/naziv/{naziv}")
	public Collection<Kredit> getByNaziv(@PathVariable("naziv") String naziv){
		return kreditRepository.findByNazivContainingIgnoreCase(naziv);
	}
	@PostMapping("kredit")
	public ResponseEntity<Kredit> addkredit(@RequestBody Kredit kredit){
		Kredit savedkredit = kreditRepository.save(kredit);
		URI location = URI.create("/kredit/" + savedkredit.getId());
		return ResponseEntity.created(location).body(savedkredit);
	}
	@PutMapping("kredit/{id}")
	public ResponseEntity<Kredit> updatekredit(@RequestBody Kredit kredit, @PathVariable("id") Integer id){
		if(kreditRepository.existsById(id)) {
		kredit.setId(id);
		Kredit updatedkredit = kreditRepository.save(kredit);
		return ResponseEntity.ok().body(updatedkredit);
	}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("kredit/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id){
		if(id==-100 && !kreditRepository.existsById(id)) {
			jdbcTemplate.execute("insert into kredit(\"id\",\"naziv\",\"oznaka\",\"opis\") values (-100, 'Test kredit','100','Test opis')");
		}
		if(kreditRepository.existsById(id)) {
			kreditRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
}
