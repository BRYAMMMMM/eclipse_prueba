package ec.edu.ups.ppw.demojakarta.model1;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;


@Table(name="TBL_RIFA")

@Entity

public class Rifa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ri_id")
	private int id;
	
	
	@Column(name="ri_nombre")
	private String nombre;
	

	@Column(name="ri_razon")
	private String razon;
	


	@Column(name="ri_fecha")
	private String fecha;

	@Column(name="ri_valorBoleto")
	private double valorBoleto;
	

	@Column(name="ri_cantidadBoletos")
	private int cantidadBoletos;
	
	
	
	
	@OneToMany(mappedBy = "rifa", cascade = CascadeType.ALL)
    private List<Premio> premios;
	
    @OneToMany(mappedBy = "rifa", cascade = CascadeType.ALL)
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


	public String getRazon() {
		return razon;
	}


	public void setRazon(String razon) {
		this.razon = razon;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public double getValorBoleto() {
		return valorBoleto;
	}


	public void setValorBoleto(double valorBoleto) {
		this.valorBoleto = valorBoleto;
	}


	public int getCantidadBoletos() {
		return cantidadBoletos;
	}


	public void setCantidadBoletos(int cantidadBoletos) {
		this.cantidadBoletos = cantidadBoletos;
	}
	
	

}
