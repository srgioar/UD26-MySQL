package app.service;

import java.util.List;

import app.dto.AsignadoA;

public interface IAsignadoAService {
	
	public List<AsignadoA> listarAsignadoA();
	public AsignadoA guardarAsignadoA(AsignadoA asignadoA);
	public AsignadoA asignadoAXID(long id);
	public AsignadoA actualizarAsignadoA(AsignadoA asignadoA);
	public void eliminarAsignadoA(long id);

}
