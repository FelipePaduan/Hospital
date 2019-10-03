package dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Animal;
import util.JPAUtil;

public class DAOAnimal {
    EntityManager manager;

    public Animal buscaPorAnimal(String nome, String raca) throws ExcecaoObjetoNaoEncontrado{
        Animal temp = null;
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT a FROM Animal a WHERE a.nome = :nome AND a.raca =:raca";
        TypedQuery<Animal> query = manager.createQuery(sql, Animal.class);
        query.setParameter("nome", nome);
        query.setParameter("raca", raca);

        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  
            throw new ExcecaoObjetoNaoEncontrado("Nenhum objeto com este nome");
        } finally {
            manager.close();
        }
        return temp;
    }
    
}
