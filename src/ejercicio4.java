import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

// Clase para representar cada nivel del juego
class Nivel {
    // Atributos de la clase
    private int dificultad;
    private List<String> desafios;

    // Constructor de la clase
    public Nivel(int dificultad, List<String> desafios) {
        this.dificultad = dificultad;
        this.desafios = desafios;
    }

    // Métodos getter para obtener los atributos
    public int getDificultad() {
        return dificultad;
    }

    public List<String> getDesafios() {
        return desafios;
    }
}

// Clase principal que contiene el método para jugar un nivel
public class ejercicio4 {

    private static Scanner scanner = new Scanner(System.in);

    private static Map<String, String> respuestasCorrectas = new HashMap<>();
    private static List<Nivel> niveles = new ArrayList<>();

    static {
        // Inicializamos el mapa con las preguntas y sus respuestas correctas
        respuestasCorrectas.put("loop", "con un for");
        respuestasCorrectas.put("condicional", "si");
        respuestasCorrectas.put("variable", "almacenar");
        respuestasCorrectas.put("tipoDeDato", "string");
        respuestasCorrectas.put("funcion", "con un sout");
        respuestasCorrectas.put("entorno", "programar");

        // Definición de niveles
        niveles.add(new Nivel(1, new ArrayList<>(List.of("entorno", "condicional"))));
        niveles.add(new Nivel(2, new ArrayList<>(List.of("variable", "tipoDeDato"))));
        niveles.add(new Nivel(3, new ArrayList<>(List.of("funcion", "loop", "condicional"))));
    }

    private static void resolverDesafio(String desafio) {
        switch (desafio) {
            case "entorno":
                System.out.println("¿Qué se hace en un entorno de desarrollo?");
                break;
            case "loop":
                System.out.println("¿Cómo harías para repetir una acción 5 veces?");
                break;
            case "condicional":
                System.out.println("Si tienes 2 manzanas y Tapia te da 5 más, ¿tienes más de 4 manzanas?");
                break;
            case "variable":
                System.out.println("¿Para qué sirve una variable?");
                break;
            case "tipoDeDato":
                System.out.println("¿Como se declara una cadena de texto en Java?");
                break;
            case "funcion":
                System.out.println("¿Cómo le dirías a un ordeneador que salude, usando una función?");
                break;
            default:
                System.out.println("Este desafio es nuevo, que harías para resolverlo?");
                break;
        }
        System.out.print("Tu respuesta: ");
        String respuesta = scanner.nextLine().toLowerCase().trim(); // Captura la entrada del usuario

        // Verificar si la respuesta es correcta
        if (respuestasCorrectas.getOrDefault(desafio, "").equals(respuesta)) {
            System.out.println("¡Correcto! Bien hecho.\n");
        } else {
            System.out.println("Esa no es la respuesta esperada. Sigue intentándolo y aprendiendo.\n");
        }
    }


    // Método para jugar un nivel del juego
    public static void jugarNivel(Nivel nivel) {
        System.out.println("Bienvenido al nivel " + nivel.getDificultad() + ". ¡Vamos a aprender jugando!");
        for (String desafio : nivel.getDesafios()) {
            System.out.println("Desafío: " + desafio);
            resolverDesafio(desafio);
        }
    }
    // Método para seleccionar un nivel para jugar
    private static void seleccionarNivel() {
        System.out.println("Selecciona un nivel para jugar (1-" + niveles.size() + "):");
        int eleccion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        if (eleccion >= 1 && eleccion <= niveles.size()) {
            jugarNivel(niveles.get(eleccion - 1));
        } else {
            System.out.println("Elección inválida. Por favor, selecciona un nivel válido.");
            seleccionarNivel(); // Recursividad para pedir una nueva elección
        }
    }

    // Método principal para ejecutar el juego
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido a Aprende Jugando!");
        System.out.println("Este juego te ayudará a aprender conceptos básicos de programación.");
        System.out.println("Cada nivel tiene desafíos que te ayudarán a aprender y practicar.");
        System.out.println("¡Vamos a empezar!\n");

        seleccionarNivel(); // Iniciar el juego
    }
}
