package pe.edu.upeu.sysalmacenfx.servicio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.CompCarrito;
import pe.edu.upeu.sysalmacenfx.repositorio.CompCarritoRepository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

@Service
public class CompCarritoService {


    @Autowired
    CompCarritoRepository repo;
    public CompCarrito save(CompCarrito to){
        return repo.save(to);
    }

    public List<CompCarrito> List(){
        return repo.findAll();
    }
    public CompCarrito update(CompCarrito to, Long id){
        try{
            CompCarrito toe=repo.findById(id).get();
            if(toe!=null){
                toe.setNombreProducto(to.getNombreProducto());
            }
            return repo.save(toe);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        return null;

    }
    public CompCarrito update(CompCarrito to){
        return repo.save(to);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
    public CompCarrito buscarId(Long id){
        return repo.findById(id).get();
    }
    public List<ComboBoxOption>listarCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        for (CompCarrito cate : repo.findAll()) {
            listar.add(new ComboBoxOption(String.valueOf(cate.getIdCompCarrito()),cate.getNombreProducto()
            ));

        }
        return listar;
    }
}
