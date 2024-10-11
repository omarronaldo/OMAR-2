package pe.edu.upeu.sysalmacenfx.pruebas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.upeu.sysalmacenfx.modelo.Categoria;
import pe.edu.upeu.sysalmacenfx.repositorio.CategoriaRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Component
public class MainX {
    private final Scanner scanner = new Scanner(System.in);

    @Autowired
    private CategoriaRepository repository;

    public void registro() {
        System.out.println("MAIN CATEGORIA");
        while (true) {
            System.out.print("Escriba el nombre de la categoría o 'salir' para terminar: ");
            String nombreCategoria = scanner.nextLine().trim();

            if (nombreCategoria.equalsIgnoreCase("salir")) {
                break;
            }

            if (nombreCategoria.isEmpty()) {
                System.out.println("El espacio no puede estar vacío, inténtelo otra vez.");
                continue;
            }

            Categoria categoria = new Categoria();
            categoria.setNombre(nombreCategoria);
            Categoria guardada = repository.save(categoria);
            System.out.println("Categoría registrada: ID = " + guardada.getIdCategoria() + ", Nombre = " + guardada.getNombre());
        }
    }

    public void listar() {
        List<Categoria> categorias = repository.findAll();
        System.out.println("ID\tNombre");
        for (Categoria categoria : categorias) {
            System.out.println(categoria.getIdCategoria() + "\t" + categoria.getNombre());
        }
    }

    public void actualizar() {
        try {
            System.out.print("Escribe el ID de la categoría que quieres modificar: ");
            Long idModificar = scanner.nextLong();
            scanner.nextLine(); // Limpiar el buffer

            Categoria categoriaExistente = repository.findById(idModificar).orElse(null);
            if (categoriaExistente == null) {
                System.out.println("No se encontró la categoría con esa ID.");
                return;
            }

            System.out.print("Escribe el nuevo nombre de la categoría: ");
            String nuevoNombre = scanner.nextLine();
            categoriaExistente.setNombre(nuevoNombre);
            repository.save(categoriaExistente);
            System.out.println("Categoría actualizada: ID = " + categoriaExistente.getIdCategoria() + ", Nuevo Nombre = " + categoriaExistente.getNombre());
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.nextLine(); // Limpiar el buffer
        }
    }

    public void borrar() {
        try {
            System.out.print("Escribe el ID de la categoría que quieres eliminar: ");
            Long idEliminar = scanner.nextLong();
            repository.deleteById(idEliminar);
            System.out.println("Categoría eliminada con éxito.");
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.nextLine(); // Limpiar el buffer
        }
    }

    public void menu() {
        int opcion;
        String mensaje = "Seleccione una opción es para Omar Ronaldo Mamani Pampa:\n1 = Crear\n2 = Listar\n3 = Actualizar\n4 = Borrar\n0 = Salir";

        do {
            System.out.println(mensaje);
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1 -> registro();
                case 2 -> listar();
                case 3 -> actualizar();
                case 4 -> borrar();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private int obtenerOpcion() {
        int opcion = -1;
        while (opcion < 0 || opcion > 4) {
            System.out.print("Ingrese una opción: ");
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }
        return opcion;
    }
}
