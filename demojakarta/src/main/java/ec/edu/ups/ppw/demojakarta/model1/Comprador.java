package ec.edu.ups.ppw.demojakarta.model1;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "TBL_COMPRADOR")
@Entity
public class Comprador {
    
    @Id
    @Column(name = "co_id")
    private int id;

    @Column(name = "co_nombre")
    private String nombre;
    
    @Column(name = "co_correo_electronico")
    private String correoElectronico;
    
    
    @OneToMany(mappedBy = "comprador", cascade = CascadeType.ALL)
    private List<Boleto> boletos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

   
}
