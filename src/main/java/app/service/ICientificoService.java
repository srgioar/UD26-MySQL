package app.service;

import java.util.List;

import app.dto.Cientifico;

public interface ICientificoService {
	
	public List<Cientifico> listarCientificos();
	public Cientifico guardarCientifico(Cientifico cientifico);
	public Cientifico cientificoXID (long id);
	public Cientifico actualizarCientifico(Cientifico cientifico);
	public void eliminarCientifico(long id);

}
