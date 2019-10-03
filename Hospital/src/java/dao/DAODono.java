package dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Dono;
import util.JPAUtil;

public class DAODono {
    EntityManager manager;
    
    public Dono buscaPorDono(String nome) throws ExcecaoObjetoNaoEncontrado{
        Dono temp = null;
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT a FROM Dono a WHERE a.nome = :nome";
        TypedQuery<Dono> query = manager.createQuery(sql, Dono.class);
        query.setParameter("nome", nome);
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  
            throw new ExcecaoObjetoNaoEncontrado("Nenhum objeto com este login");
        } finally {
            manager.close();
        }
        return temp;
    }
    
}
