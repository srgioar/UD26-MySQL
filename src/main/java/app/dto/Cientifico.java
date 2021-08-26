package app.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cientificos")

public class Cientifico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "DNI")
	private String DNI;
	@Column(name ="NomApells")
	private String nomApells;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<AsignadoA> asignadoA;
	
	public Cientifico() {}
	
	public Cientifico(long id, String DNI, String nomApells) {
		this.id = id;
		this.DNI = DNI;
		this.nomApells = nomApells;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNomApells() {
		return nomApells;
	}

	public void setNomApells(String nomApells) {
		this.nomApells = nomApells;
	}
	
	// Jsonignore + FetchType.LAZY para evitar bucle infinito entre relaciones:
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "AsignadoA")
	public List<AsignadoA> getAsignadoA(){
		return asignadoA;
	}
	
	public void setAsignadoA(List<AsignadoA> asignadoA){
		this.asignadoA = asignadoA;
	}
	
	@Override
	public String toString() {
		return "";
		
	}
	
	

}
