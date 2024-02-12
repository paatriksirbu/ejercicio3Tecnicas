import java.util.*;

class Aplicacion{   //Necesitamos una clase para representar las aplicaciones.
    String nombre;

    public Aplicacion(String nombre) {
        this.nombre = nombre;
    }
    //Método getter para obtener el nombre
    public String getNombre() {
        return nombre;
    }
}

class Rendimiento{  //Necesitamos una clase para representar el rendimiento de las aplicaciones.
    double cpu;
    double memoria;
    double tiempoRespuesta;

    public Rendimiento(double cpu, double memoria, double tiempoRespuesta) {    //Constructor de la clase
        this.cpu = cpu;
        this.memoria = memoria;
        this.tiempoRespuesta = tiempoRespuesta;
    }

    //Métodos getter para obtener los atributos
    public double getCpu() {
        return cpu;
    }

    public double getMemoria() {
        return memoria;
    }

    public double getTiempoRespuesta() {
        return tiempoRespuesta;
    }

}
public class ejercicio5 {
    // Método que recibe una aplicación y muestra su rendimiento
    public static Rendimiento obtenerRendimiento(Aplicacion app){
        Random random = new Random();
        double cpu = 10 + (90 - 10) * random.nextDouble(); // CPU uso en porcentaje
        double memoria = 100 + (1024 - 100) * random.nextDouble(); // Memoria uso en MB
        double tiempoRespuesta = 10 + (1000 - 10) * random.nextDouble(); // Tiempo de respuesta en ms
        return new Rendimiento(cpu, memoria, tiempoRespuesta);
    }

    // Obtiene el rendimiento de la aplicación
    public static void monitorearAplicacion(Aplicacion app){

        Rendimiento rendimiento = obtenerRendimiento(app);  //Obtenemos el rendimiento de la aplicación
        System.out.println("Rendimiento de la aplicación " + app.getNombre());

        //Mostramos el rendimiento de la aplicación
        System.out.println("CPU: " + String.format("%.2f%%", rendimiento.getCpu()));
        System.out.println("Memoria: " + String.format("%.2fMB", rendimiento.getMemoria()));
        System.out.println("Tiempo de respuesta: " + String.format("%.2fms", rendimiento.getTiempoRespuesta()));
    }

    // Método principal
    public static void main(String[] args) {
        List<Aplicacion> aplicaciones = new ArrayList<>();     // Creamos una lista de aplicaciones
        aplicaciones.add(new Aplicacion("App1"));
        aplicaciones.add(new Aplicacion("App2"));
        aplicaciones.add(new Aplicacion("App3"));

        for (Aplicacion app : aplicaciones){    // Mostramos el rendimiento de cada aplicación
            monitorearAplicacion(app);
        }
    }

}
