package it.films.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import it.films.entity.Film;

public class FilmDao implements IFilmDao {
	
	// EntityManagerFactory permette di creare un em
	private EntityManager em = EntityManagerHelper.getEntityManager();

	@Override
	public void salva(Film f) {
		// apro la connessione con em
		em.getTransaction().begin();
		// persist
		em.persist(f);
		// commit della transazione
		em.getTransaction().commit();

	}

	@Override
	public void aggiorna(Film f) {
		em.getTransaction().begin();
		em.merge(f);
		em.getTransaction().commit();

	}

	@Override
	public Film trova(int id) {
		Film f = em.find(Film.class, id);
		return f;
	}
	
	/**
     *  Ricerca film per "regista"
     * 
     *  @author Daniele Cerulli
     *  @version 1.0
     *  @param regista : il nome del regista (attributo dell'entity Film)
     *  @return listaFilmRegista : ritorna un'oggetto di tipo List<Film>
     */
	@Override
	public List<Film> trovaRegista(String regista) {
		Query q = em.createQuery("SELECT f FROM Film f WHERE f.regista = '" + regista + "'");
		List<Film> listaFilmRegista = q.getResultList();
		return listaFilmRegista;
	}

	@Override
	public void elimina(int id) {
		em.getTransaction().begin();
		em.remove(em.find(Film.class, id));
		em.getTransaction().commit();
	}

	@Override
	public List<Film> trovaTutti() {
		Query q = em.createNamedQuery("trovatutti");
		List<Film> listaFilm = q.getResultList();
		return listaFilm;
	}

}
