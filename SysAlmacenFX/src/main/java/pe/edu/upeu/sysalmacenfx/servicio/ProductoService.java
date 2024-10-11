package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.Producto;
import pe.edu.upeu.sysalmacenfx.repositorio.ProductoRepository;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

@Service
public class ProductoService {


    @Autowired
    ProductoRepository repo;
    public Producto save(Producto to){
        return repo.save(to);
    }

    public List<Producto> List(){
        return repo.findAll();
    }
    public Producto update(Producto to, Long id){
        try{
            Producto toe=repo.findById(id).get();
            if(toe!=null){
                toe.setNombre(to.getNombre());
            }
            return repo.save(toe);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        return null;

    }
    public Producto update(Producto to){
        return repo.save(to);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
    public Producto buscarId(Long id){
        return repo.findById(id).get();
    }
    public List<ComboBoxOption>listarCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        for (Producto cate : repo.findAll()) {
            listar.add(new ComboBoxOption(String.valueOf(cate.getIdProducto()),cate.getNombre()
            ));

        }
        return listar;
    }
}

