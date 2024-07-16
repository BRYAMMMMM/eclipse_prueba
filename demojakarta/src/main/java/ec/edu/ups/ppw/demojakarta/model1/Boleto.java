package ec.edu.ups.ppw.demojakarta.model1;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "TBL_BOLETO")
@Entity
public class Boleto  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bo_id")
    private int id;

    @Column(name = "bo_numero")
    private int numero;

    @Column(name = "bo_vendido")
    private boolean vendido;
    
    @ManyToOne
    @JoinColumn(name = "ri_id") 
    private Rifa rifa;
    
    @ManyToOne
    @JoinColumn(name = "co_id")
    private Comprador comprador;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}
    
    
    
   


    // Getters y Setters
}
