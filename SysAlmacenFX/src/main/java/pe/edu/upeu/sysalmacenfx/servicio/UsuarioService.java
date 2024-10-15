package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.Usuario;
import pe.edu.upeu.sysalmacenfx.repositorio.UsuarioRepository;

import java.util.List;
@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repo;

    //C
    public Usuario save(Usuario to){
        return repo.save(to);
    }
    //R
    public List<Usuario> List(){
        return repo.findAll();
    }
    //U
    public Usuario update(Usuario to, Long id){
        try {
            Usuario toe=repo.findById(id).get();
            if(toe!=null) {
                toe.setIdUsuario(to.getIdUsuario());
            }
            return repo.save(toe);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        return null;
    }
    public Usuario update(Usuario to){
        return repo.save(to);
    }

    //D
    public void delete(Long id){
        repo.deleteById(id);
    }
    //B
    public Usuario searchId(Long id){
        return repo.findById(id).get();
    }
}
