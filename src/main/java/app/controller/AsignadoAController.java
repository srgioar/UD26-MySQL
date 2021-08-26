package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.AsignadoA;
import app.service.AsignadoASrvImp;

@RestController
@RequestMapping("/api")
public class AsignadoAController {
	
	@Autowired
	AsignadoASrvImp asignadoASrvImp;
	
	@GetMapping("/asignadoA")
	public List<AsignadoA> listarAsignadoA(){
		
		return asignadoASrvImp.listarAsignadoA();
	}
	
	@PostMapping("/asignadoA")
	public AsignadoA salvarAsignadoA(@RequestBody AsignadoA asignadoA) {
		
		return asignadoASrvImp.guardarAsignadoA(asignadoA);
	}
	
	@GetMapping("/asignadoA/{id}")
	public AsignadoA asignadoAXID(@PathVariable(name="id") int id) {
		
		AsignadoA asignadoA_xid = new AsignadoA();
		asignadoA_xid = asignadoASrvImp.asignadoAXID(id);
		return asignadoA_xid;
		
	}
	
	@PutMapping("/asignadoA/{id}")
	public AsignadoA actualizarAsignadoA(@PathVariable(name="id") int id, @RequestBody AsignadoA asignadoA) {
		
		AsignadoA asignadoA_sel = new AsignadoA();
		AsignadoA asignadoA_actual = new AsignadoA();
		
		asignadoA_sel = asignadoASrvImp.asignadoAXID(id);
		
		asignadoA_sel.setCientifico(asignadoA.getCientifico());
		asignadoA_sel.setProyecto(asignadoA.getProyecto());
		
		asignadoA_actual = asignadoASrvImp.actualizarAsignadoA(asignadoA_sel);
		
		return asignadoA_actual;
	}
	
	@DeleteMapping("/asignadoA/{id}")
	public void eliminarAsignadoA(@PathVariable(name="id") int id) {
		
		asignadoASrvImp.eliminarAsignadoA(id);
		
	}

}
