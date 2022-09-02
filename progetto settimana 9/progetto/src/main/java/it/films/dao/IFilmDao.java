package it.films.dao;

import java.util.List;

import it.films.entity.Film;


public interface IFilmDao {
	
	public void salva(Film f);
	public void aggiorna(Film f);
	public Film trova(int id);
	public List<Film> trovaRegista(String nomeRegista);
	public void elimina(int id);
	public List<Film> trovaTutti();

}
