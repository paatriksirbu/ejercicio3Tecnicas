import java.util.ArrayList;
import java.util.HashMap;

public class ejercicio2 {
    // Método que recibe un usuario y devuelve una lista de libros que aún no ha calificado.
    public static ArrayList<Libro> recomendarLibros(Usuario usuario) {
        ArrayList<Libro> recomendaciones = new ArrayList<>();
        for (Libro libro : usuario.getLibrosInteresantes()) {
            if (!usuario.getCalificaciones().containsKey(libro)) {
                recomendaciones.add(libro);
            }
        }
        return recomendaciones;
    }

    public static void main(String[] args) {
        // Creamos un usuario y le agregamos libros de interés y calificaciones
        Usuario usuarioActual = new Usuario();

        Libro libro1 = new Libro("El señor de los anillos", "J.R.R. Tolkien");
        Libro libro2 = new Libro("Harry Potter", "J.K. Rowling");
        Libro libro3 = new Libro("Cien años de soledad", "Gabriel García Márquez");
        Libro libro4 = new Libro("1984", "George Orwell");
        Libro libro5 = new Libro("To Kill a Mockingbird", "Harper Lee");
        Libro libro6 = new Libro("The Great Gatsby", "F. Scott Fitzgerald");
        Libro libro7 = new Libro("Moby Dick", "Herman Melville");

        usuarioActual.agregarLibroInteres(libro1);
        usuarioActual.agregarLibroInteres(libro2);
        usuarioActual.agregarLibroInteres(libro5);
        usuarioActual.agregarLibroInteres(libro7);

        usuarioActual.calificarLibro(libro1, 7);
        usuarioActual.calificarLibro(libro2, 8);

        //Mostramos recomendaciones al usuario.
        ArrayList<Libro> recomendaciones = recomendarLibros(usuarioActual);
        System.out.println("Recomendaciones: ");
        for (Libro libro : recomendaciones) {
            System.out.println(libro);
        }
    }

    // Creamos la clase Libro con dos atributos, constructor getters y toString.
    public static class Libro {
        private String titulo;
        private String autor;

        public Libro(String titulo, String autor) {
            this.titulo = titulo;
            this.autor = autor;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getAutor() {
            return autor;
        }

        @Override
        public String toString() {
            return "Libro{" +
                    "titulo='" + titulo + '\'' +
                    ", autor='" + autor + '\'' +
                    '}';
        }
    }

    public static class Usuario {
        private ArrayList<Libro> librosInteresantes;    // Lista de libros que le interesan
        private HashMap<Libro, Integer> calificaciones; // Libro y calificación

        public Usuario() {
            librosInteresantes = new ArrayList<>();
            calificaciones = new HashMap<>();
        }

        // Agrega un libro a la lista de intereses si aún no está calificado
        public void agregarLibroInteres(Libro libro) {
            if (!calificaciones.containsKey(libro)) {
                librosInteresantes.add(libro);
            }
        }

        // Calificar un libro
        public void calificarLibro(Libro libro, int calificacion) {
            calificaciones.put(libro, calificacion);
        }

        // Getters
        public ArrayList<Libro> getLibrosInteresantes() {
            return librosInteresantes;
        }

        public HashMap<Libro, Integer> getCalificaciones() {
            return calificaciones;
        }
    }
}
