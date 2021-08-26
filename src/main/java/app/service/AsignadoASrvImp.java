package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.IAsignadoADAO;
import app.dto.AsignadoA;

@Service
public class AsignadoASrvImp implements IAsignadoAService {
	
	@Autowired
	IAsignadoADAO iAsignadoDAO;

	@Override
	public List<AsignadoA> listarAsignadoA() {
		// TODO Auto-generated method stub
		return iAsignadoDAO.findAll();
	}

	@Override
	public AsignadoA guardarAsignadoA(AsignadoA asignadoA) {
		// TODO Auto-generated method stub
		return iAsignadoDAO.save(asignadoA);
	}

	@Override
	public AsignadoA asignadoAXID(long id) {
		// TODO Auto-generated method stub
		return iAsignadoDAO.findById(id).get();
	}

	@Override
	public AsignadoA actualizarAsignadoA(AsignadoA asignadoA) {
		// TODO Auto-generated method stub
		return iAsignadoDAO.save(asignadoA);
	}

	@Override
	public void eliminarAsignadoA(long id) {
		// TODO Auto-generated method stub
		iAsignadoDAO.deleteById(id);
		
	}

}
