package controle;

import dao.DAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Dono;

@ManagedBean (name="donoControle")
@ViewScoped
public class DonoControle {
    private List<Dono> donos;
    private Dono donoSelecionado;
    private DAO<Dono> dao;
    
    public DonoControle(){
        donoSelecionado = new Dono();
        dao = new DAO(Dono.class);
        donos = dao.listarTodos();
    }

    public List<Dono> getDonos() {
        return donos;
    }

    public void setDonos(List<Dono> donos) {
        this.donos = donos;
    }

    public Dono getDonoSelecionado() {
        return donoSelecionado;
    }

    public void setDonoSelecionado(Dono donoSelecionado) {
        this.donoSelecionado = donoSelecionado;
    }

    public DAO<Dono> getDao() {
        return dao;
    }

    public void setDao(DAO<Dono> dao) {
        this.dao = dao;
    }
    
    
    

    
}
