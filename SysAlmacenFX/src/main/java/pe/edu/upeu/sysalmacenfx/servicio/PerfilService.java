package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.Perfil;
import pe.edu.upeu.sysalmacenfx.repositorio.PerfilRepository;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

@Service
public class PerfilService {


    @Autowired
    PerfilRepository repo;
    public Perfil save(Perfil to){
        return repo.save(to);
    }

    public List<Perfil> List(){
        return repo.findAll();
    }
    public Perfil update(Perfil to, Long id){
        try{
            Perfil toe=repo.findById(id).get();
            if(toe!=null){
                toe.setNombre(to.getNombre());
            }
            return repo.save(toe);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        return null;

    }
    public Perfil update(Perfil to){
        return repo.save(to);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
    public Perfil buscarId(Long id){
        return repo.findById(id).get();
    }
    public List<ComboBoxOption>listarCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        for (Perfil cate : repo.findAll()) {
            listar.add(new ComboBoxOption(String.valueOf(cate.getIdPerfil()),cate.getNombre()
            ));

        }
        return listar;
    }
}

