import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Publicacion{
    String texto;

    public Publicacion(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
public class ejercicio3 {
    private static final double UMBRAL_POS = 1;
    private static final double UMBRAL_NEG = -1;
    private static final List<String> palabrasPos = Arrays.asList("feliz", "genial", "fantástico", "positivo", "amor");
    private static final List<String> palabrasNeg = Arrays.asList("triste", "horrible", "negativo", "odio", "malo");

    public String analizarSentimiento(String texto){
        double sentimiento = analizarTexto(texto);
        if (sentimiento > UMBRAL_POS){
            return "positivo";
        } else if (sentimiento < UMBRAL_NEG) {
            return "negativo";
        } else {
            return "negativo";
        }
    }

    public static double analizarTexto(String texto){
        int contadorPos = 0;
        int contadorNeg = 0;
        String textLower = texto.toLowerCase();

        for (String palabra : palabrasPos){     //contamos las palabras positivas
            if (textLower.contains(palabra)){
                contadorPos++;
            }
        }

        for (String palabra : palabrasNeg){     //contamos las palabras negativas
            if (textLower.contains(palabra)){
                contadorNeg++;
            }
        }

        if (contadorPos > contadorNeg){
            return 1;
        } else if (contadorNeg > contadorPos) {
            return -1;
        } else{
            return 0;
        }

    }

    public void analizarPublicaciones(List<Publicacion> publicaciones){
        for (Publicacion publicacion : publicaciones){
            String sentimiento = analizarSentimiento(publicacion.texto);
            System.out.println("Publicacion: " + publicacion.texto + " - " + "Sentimiento: " + sentimiento);
        }
    }

    public static void main(String[] args) {

        List<Publicacion> publicaciones = new ArrayList<>();
        publicaciones.add(new Publicacion("Hoy hace un dia genial"));
        publicaciones.add(new Publicacion("La noticia que he escuchado hoy es muy triste"));
        publicaciones.add(new Publicacion("Hoy es un dia como cualquier otro"));
        publicaciones.add(new Publicacion("Mañana sera un dia horrible"));

        for (Publicacion publicacion : publicaciones){
            double resultado = analizarTexto(publicacion.getTexto());
            System.out.println("El sentimiento del texto es: " + (resultado == 1 ? "Positivo" : resultado == -1 ? "Negativo" : "Neutral"));
        }



    }
}
