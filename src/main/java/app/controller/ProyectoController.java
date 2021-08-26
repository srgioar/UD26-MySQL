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

import app.dto.Proyecto;
import app.service.ProyectoSrvImp;

@RestController
@RequestMapping("/api")
public class ProyectoController {
	
	@Autowired
	ProyectoSrvImp proyectoSrvImp;
	
	@GetMapping("/proyectos")
	public List<Proyecto> listarProyectos(){
		
		return proyectoSrvImp.listarProyectos();
		
	}
	
	@PostMapping("/proyectos")
	public Proyecto salvarProyectos(@RequestBody Proyecto proyecto) {
		
		return proyectoSrvImp.guardarProyecto(proyecto);
		
	}
	
	@GetMapping("/proyectos/{id}")
	public Proyecto proyectoXID(@PathVariable(name="id") int id) {
		
		Proyecto proyecto_xid = new Proyecto();
		
		proyecto_xid = proyectoSrvImp.proyectoXID(id);
		return proyecto_xid;
		
	}
	
	@PutMapping("/proyectos/{id}")
	public Proyecto actualizarProyecto(@PathVariable(name="id")int id, @RequestBody Proyecto proyecto) {
		
		Proyecto proyecto_sel = new Proyecto();
		Proyecto proyecto_actual = new Proyecto();
		
		proyecto_sel = proyectoSrvImp.proyectoXID(id);
		
		proyecto_sel.setHoras(proyecto.getHoras());
		proyecto_sel.setNombre(proyecto.getNombre());
		
		proyecto_actual = proyectoSrvImp.actualizarProyecto(proyecto_sel);
		
		return proyecto_actual;
		
	}
	
	@DeleteMapping("/proyectos/{id}")
	public void eliminarProyecto(@PathVariable(name="id") int id) {
		
		proyectoSrvImp.eliminarProyecto(id);
		
	}
	

}
