package controle;

import dao.DAO;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Animal;

@ManagedBean (name = "novoAnimal")
@ViewScoped
public class NovoAnimal implements Serializable{
    private Animal animal;
    private DAO<Animal> dao; 
    
    public NovoAnimal(){
        animal = new Animal();
        dao = new DAO(Animal.class);
    }
    
    public void salvar(){
        dao.inserir(animal);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage
          (null, new FacesMessage(FacesMessage.SEVERITY_INFO,
          "Animal cadastrado", null));
    }
    

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public DAO<Animal> getDao() {
        return dao;
    }

    public void setDao(DAO<Animal> dao) {
        this.dao = dao;
    }
}
