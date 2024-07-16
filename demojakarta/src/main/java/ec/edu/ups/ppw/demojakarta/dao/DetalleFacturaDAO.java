package ec.edu.ups.ppw.demojakarta.dao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ec.edu.ups.ppw.demojakarta.model1.DetalleFactura;

@Stateless

public class DetalleFacturaDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public void insert(DetalleFactura detalleFactura) {
        em.persist(detalleFactura);
    }
    
    public void update(DetalleFactura detalleFactura) {
        em.merge(detalleFactura);
    }
    
    public void delete(int codigo) {
        DetalleFactura detalleFactura = this.read(codigo);
        em.remove(detalleFactura);
    }
    
    public DetalleFactura read(int codigo) {
        DetalleFactura detalleFactura = em.find(DetalleFactura.class, codigo);
        return detalleFactura;
    }
    
    public List<DetalleFactura> getAll() {
        String jpql = "SELECT d FROM DetalleFactura d"; 
        Query query = em.createQuery(jpql, DetalleFactura.class);
        return query.getResultList();
    }
}