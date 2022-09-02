package it.films.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import it.films.dao.FilmDao;
import it.films.dto.FilmDto;
import it.films.entity.Film;

@RequestMapping("/films")
@RestController
@Api(value = "Films Rest Service", tags = "Gestione dei films con DB")
public class FilmRest {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	private FilmDao filmDao;
	
	public FilmDao getFilmDao() {
		if (filmDao == null) {
			filmDao = new FilmDao();
		}
		return filmDao;
	}
	@ApiOperation(
			// descrizione
			value = "Mostra tutti i Films",
			// cosa produce
			produces = "application/json",
			response = Film.class, responseContainer = "List" )
	@GetMapping
	public ResponseEntity<List<Film>> trovaTutti() {
		try {
			return new ResponseEntity<List<Film>>(getFilmDao().trovaTutti(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Film>>((List<Film>)null, HttpStatus.METHOD_FAILURE);
		}
	
	}
	
	@ApiOperation(value = "Elimina un film dal DB")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFilm(@PathVariable int id) {
		try {
			getFilmDao().elimina(id);
			return new ResponseEntity<String>("Film eliminato! id -> " + id, HttpStatus.OK);
			} catch (Exception e) {
			return new ResponseEntity<String>("Il Film NON è stato eliminato! id -> " + id, HttpStatus.BAD_REQUEST);
		}
	
	}
	
	@PostMapping
	@ApiOperation(
			value = "Inserisce un Film nel DB",
			consumes = "application/json")
	public ResponseEntity<String> inserisciFilm(@RequestBody FilmDto fDto) {
		Film f = new Film();
		f.setTitolo(fDto.getTitolo());
		f.setAnno(fDto.getAnno());
		f.setRegista(fDto.getRegista());
		f.setTipo(fDto.getTipo());
		// utilizzo BCrypt per criptare l'incasso come da richiesta della traccia
		String incassoCriptato = BCrypt.hashpw(fDto.getIncasso(), BCrypt.gensalt());
		f.setIncasso(incassoCriptato);
		try {
			getFilmDao().salva(f);
			return new ResponseEntity<String>("Film inserito! -> " + f, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Il Film NON è stato inserito! -> " + f, HttpStatus.BAD_REQUEST);
		}
	
	}
	
	@PutMapping("/{id}")
	@ApiOperation(
			value = "Aggiorna un Film presente nel DB",
			consumes = "application/json")
	public ResponseEntity<String> aggiornaFilm(@RequestBody FilmDto fDto, @PathVariable int id) {
		Film f = new Film();
		f.setTitolo(fDto.getTitolo());
		f.setAnno(fDto.getAnno());
		f.setRegista(fDto.getRegista());
		f.setTipo(fDto.getTipo());
		String incassoCriptato = BCrypt.hashpw(fDto.getIncasso(), BCrypt.gensalt());
		f.setIncasso(incassoCriptato);
		f.setId(id);
		try {
			getFilmDao().aggiorna(f);
			return new ResponseEntity<String>("Film modificato! -> " + f, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Il Film NON è stato modificato! -> " + f, HttpStatus.METHOD_FAILURE);
		}
	
	}
	
	@GetMapping("/byregista")
	@ApiOperation(
			value = "Ricerca Film per Regista",
			produces = "application/json",
			response = Film.class, responseContainer = "List")
	public ResponseEntity<List<Film>> ricercaByRegista(@RequestParam String regista) {
		try {
			log.info("Ricerca completata, consulta i risultati!");
			return new ResponseEntity<List<Film>>(getFilmDao().trovaRegista(regista), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Film>>((List<Film>)null, HttpStatus.METHOD_FAILURE);
		}
	
	}
	
}
