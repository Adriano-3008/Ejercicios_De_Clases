import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Libros implements Serializable {
    private static final long serialVersionUID = 1L;
    private String titulo;
    private String autor;
    private int anio;

    public Libros(String titulo, String autor, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public int getAnio() {
        return anio;
    }

    public static void serializarLibros(ArrayList<Libros> libros, String archivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(libros);
        }catch (IOException e) {
            System.err.println("Error al serializar la lista de libros: " + e.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    public static ArrayList<Libros> deserializarLibros(String archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (ArrayList<Libros>) ois.readObject();
        }catch (IOException e) {
            System.err.println("Error al deserializar la lista de libros: " + e.getMessage());
            return new ArrayList<>();
        }catch (ClassNotFoundException e) {
            System.err.println("Clase no encontrada: " + e.getMessage());
            return new ArrayList<>();
        }

    }

}

public class SerializacionInventarioDeLibros {
    public static void main(String[] args) throws Exception {
        Libros libro1 = new Libros("El Principito", "Antoine de Saint-Exupéry", 1943);
        Libros libro2 = new Libros("Cien años de soledad", "Gabriel García Márquez", 1967);
        Libros libro3 = new Libros("1984", "George Orwell", 1949);

        ArrayList<Libros> listaLibros = new ArrayList<>();
        listaLibros.add(libro1);
        listaLibros.add(libro2);
        listaLibros.add(libro3);
        System.out.println("");
        // Serializar la lista de libros
        String archivo = "libros.ser";
        Libros.serializarLibros(listaLibros, archivo);
        System.out.println("Lista de libros serializada en: " + archivo);

        // Deserializar la lista de libros
        ArrayList<Libros> librosDeserializados = Libros.deserializarLibros(archivo);
        System.out.println("Lista de libros deserializada:");
        for (Libros libro : librosDeserializados) {
            System.out.println("Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor() + ", Año: " + libro.getAnio());
        }
    }
}

