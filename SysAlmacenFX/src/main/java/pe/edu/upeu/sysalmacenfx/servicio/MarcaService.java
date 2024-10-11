package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.Categoria;
import pe.edu.upeu.sysalmacenfx.modelo.Marca;
import pe.edu.upeu.sysalmacenfx.repositorio.MarcaRepository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

@Service
public class MarcaService {


    @Autowired
    MarcaRepository repo;
    public Marca save(Marca to){
        return repo.save(to);
    }

    public List<Marca> List(){
        return repo.findAll();
    }
    public Marca update(Marca to, Long id){
        try{
            Marca toe=repo.findById(id).get();
            if(toe!=null){
                toe.setNombre(to.getNombre());
            }
            return repo.save(toe);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        return null;

    }
    public Marca update(Marca to){
        return repo.save(to);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
    public Marca buscarId(Long id){
        return repo.findById(id).get();
    }
    public List<ComboBoxOption>listarCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        for (Marca cate : repo.findAll()) {
            listar.add(new ComboBoxOption(String.valueOf(cate.getIdMarca()),cate.getNombre()
            ));

        }
        return listar;
    }
}

