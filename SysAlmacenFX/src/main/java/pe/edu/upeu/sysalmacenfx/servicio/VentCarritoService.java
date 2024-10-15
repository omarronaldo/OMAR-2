package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.VentCarrito;
import pe.edu.upeu.sysalmacenfx.repositorio.VentCarritoRepository;

import java.util.List;
@Service
public class VentCarritoService {
    @Autowired
    VentCarritoRepository repo;

    //C
    public VentCarrito save(VentCarrito to){
        return repo.save(to);
    }
    //R
    public List<VentCarrito> List(){
        return repo.findAll();
    }
    //U
    public VentCarrito update(VentCarrito to, Long id){
        try {
            VentCarrito toe=repo.findById(id).get();
            if(toe!=null) {
                toe.setIdCarrito(to.getIdCarrito());
            }
            return repo.save(toe);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        return null;
    }
    public VentCarrito update(VentCarrito to){
        return repo.save(to);
    }

    //D
    public void delete(Long id){
        repo.deleteById(id);
    }
    //B
    public VentCarrito searchId(Long id){
        return repo.findById(id).get();
    }
}
