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

import app.dto.Cientifico;
import app.service.CientificoSrvImp;

@RestController
@RequestMapping("/api")
public class CientificoController {
	
		@Autowired
		CientificoSrvImp cientificoSrvImp;
		
		@GetMapping("/cientificos")
		public List<Cientifico> listarCientificos(){
			
			return cientificoSrvImp.listarCientificos();
		}
		
		@PostMapping("/cientificos")
		public Cientifico salvarCientifico(@RequestBody Cientifico cientifico) {
			
			return cientificoSrvImp.guardarCientifico(cientifico);
		}
		
		@GetMapping("/cientificos/{id}")
		public Cientifico cientificoXID(@PathVariable(name="id") int id) {
			
			Cientifico cientifico_xid = new Cientifico();
			cientifico_xid = cientificoSrvImp.cientificoXID(id);
			return cientifico_xid;
		}
		
		@PutMapping("/cientificos/{id}")
		public Cientifico actualizarCientifico(@PathVariable(name="id") int id, @RequestBody Cientifico cientifico) {
			
			Cientifico cientifico_sel = new Cientifico();
			Cientifico cientifico_actual = new Cientifico();
			
			cientifico_sel = cientificoSrvImp.cientificoXID(id);
			
			cientifico_sel.setNomApells(cientifico.getNomApells());
			
			cientifico_actual = cientificoSrvImp.actualizarCientifico(cientifico_sel);
			
			return cientifico_actual;
		}
		
		@DeleteMapping("/cientificos/{id}")
		public void eliminarCientifico(@PathVariable(name="id") int id) {
			
			cientificoSrvImp.eliminarCientifico(id);
			
		}
	
	

}
