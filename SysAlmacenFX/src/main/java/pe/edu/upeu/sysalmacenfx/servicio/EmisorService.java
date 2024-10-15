package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.Emisor;
import pe.edu.upeu.sysalmacenfx.repositorio.EmisorRepository;

import java.util.List;
@Service
public class EmisorService {
    @Autowired
    EmisorRepository repo;

    //C
    public Emisor save(Emisor to){
        return repo.save(to);
    }
    //R
    public List<Emisor> List(){
        return repo.findAll();
    }
    //U
    public Emisor update(Emisor to, Long id){
        try {
            Emisor toe=repo.findById(id).get();
            if(toe!=null) {
                toe.setRuc(to.getRuc());
            }
            return repo.save(toe);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        return null;
    }
    public Emisor update(Emisor to){
        return repo.save(to);
    }

    //D
    public void delete(Long id){
        repo.deleteById(id);
    }
    //B
    public Emisor searchId(Long id){
        return repo.findById(id).get();
    }
}
