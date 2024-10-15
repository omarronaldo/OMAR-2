package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.CompraDetalle;
import pe.edu.upeu.sysalmacenfx.repositorio.CompraDetalleRepository;

import java.util.List;
@Service
public class CompraDetalleService {
    @Autowired
    CompraDetalleRepository repo;

    //C
    public CompraDetalle save(CompraDetalle to){
        return repo.save(to);
    }
    //R
    public List<CompraDetalle> List(){
        return repo.findAll();
    }
    //U
    public CompraDetalle update(CompraDetalle to, Long id){
        try {
            CompraDetalle toe=repo.findById(id).get();
            if(toe!=null) {
                toe.setIdCompraDetalle(to.getIdCompraDetalle());
            }
            return repo.save(toe);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        return null;
    }
    public CompraDetalle update(CompraDetalle to){
        return repo.save(to);
    }

    //D
    public void delete(Long id){
        repo.deleteById(id);
    }
    //B
    public CompraDetalle searchId(Long id){
        return repo.findById(id).get();
    }
}
