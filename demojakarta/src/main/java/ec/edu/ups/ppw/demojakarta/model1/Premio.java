package ec.edu.ups.ppw.demojakarta.model1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "TBL_PREMIO")
@Entity
public class Premio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pr_id")
    private int id;

    @Column(name = "pr_descripcion")
    private String descripcion;

    @Column(name = "pr_valor")
    private float valor;
    
    @ManyToOne
    @JoinColumn(name = "ri_id")
    private Rifa rifa;


    //getter y setters
    
    
    
	public String getDescripcion() {
		return descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}


}
