import java.util.*;

public class ejercicio3 {

    public static void main(String[] args) {
        // Crear una red de nodos y simular un ataque DDoS

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el número de nodos: ");
        int nodos = sc.nextInt();

        System.out.println("Ingrese la tasa de tráfico: ");
        double tasaDeTrafico = sc.nextDouble();

        Red red = new Red(nodos);

        System.out.println("Estado inicial de la red: ");
        red.mostrarEstado();

        System.out.println("Ingrese el nodo objetivo: ");
        int idNodoObjetivo = sc.nextInt();
        red.simularAtaqueDDoS(idNodoObjetivo, tasaDeTrafico);

        System.out.println("Estado de la red después del ataque: ");
        red.mostrarEstado();
    }

    // Creamos la clase Red con un atributo de tipo List<Nodo> y un constructor que recibe el número de nodos.
    public static class Red {
        List<Nodo> nodos;
        public Red(int numeroDeNodos) {
            nodos = new ArrayList<>();
            // Creación de nodos con capacidades aleatorias
            for (int i = 0; i < numeroDeNodos; i++) {
                nodos.add(new Nodo(i, 100 + Math.random() * 400)); // Capacidad entre 100 y 500
            }

            // Establecer conexiones aleatorias entre nodos
            for (Nodo nodo : nodos) {
                for (Nodo destino : nodos) {
                    if (nodo != destino) {
                        nodo.conectarNodo(destino, 100 + Math.random() * 400); // Capacidad de conexión
                    }
                }
            }
        }
        // Método para simular un ataque DDoS en un nodo específico con una intensidad dada.
        public void simularAtaqueDDoS(int idNodoObjetivo, double intensidad) {
            // Encuentra el nodo objetivo
            Nodo nodoObjetivo = nodos.get(idNodoObjetivo);
            nodoObjetivo.incrementarTrafico(intensidad);
        }
        // Método para mostrar el estado de la red.
        public void mostrarEstado() {
            for (Nodo nodo : nodos) {
                System.out.println("Nodo " + nodo.id + " - Tráfico: " + nodo.traficoActual + " - Capacidad: " + nodo.capacidad);
            }
        }
    }

    public static class Nodo {  // Creamos la clase Nodo con los atributos id, capacidad, tráfico actual y un mapa de conexiones.
        int id;
        double capacidad;
        double traficoActual;
        Map<Nodo, Double> conexiones;
        Random random = new Random();

        public Nodo(int id, double capacidad) {
            this.id = id;
            this.capacidad = capacidad;
            this.traficoActual = 0.0;
            this.conexiones = new HashMap<>();
        }


        public void conectarNodo(Nodo destino, double capacidad){ // Conecta un nodo con otro nodo con una capacidad
            conexiones.put(destino, capacidad);
        }

        public boolean incrementarTrafico(double cantidad) {    // Incrementa el tráfico del nodo
            if (traficoActual + cantidad > capacidad) {
                // Simula la congestión no aceptando más tráfico
                return false;
            }
            traficoActual += cantidad;
            return true;
        }
        // Método para enrutar un paquete a un nodo aleatorio.
        public void enrutarPaquete(double cantidad) {
            if (conexiones.isEmpty()) return; // No hay conexiones para enrutar

            // Selecciona una conexión aleatoria para simular enrutamiento simple
            Object[] nodos = conexiones.keySet().toArray();
            Nodo destino = (Nodo) nodos[random.nextInt(nodos.length)];

            // Intenta incrementar el tráfico hacia el destino
            destino.incrementarTrafico(cantidad);
        }
        // Método para simular el tráfico en la red.
        public void simularTrafico(double tasaDeTráfico) {
            double variacion = Math.random() * 0.2 * tasaDeTráfico;
            this.traficoActual += tasaDeTráfico + variacion;
        }

    }
}
