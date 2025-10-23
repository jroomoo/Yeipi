import com.coti.tools.Esdia;

import modelo.Director;
import modelo.Pelicula;
import modelo.Videoteca;
 

public class App {
    public static void main(String[] args) throws Exception {


        Videoteca videoteca = new Videoteca(4);

        boolean continuar = true;

        while (continuar) {
        System.out.println("|---------------------------------------------|");
        System.out.println("|                  MI VIDEOTECA               |");
        System.out.println("|---------------------------------------------|");
        System.out.println("|                                             |");
        System.out.println("| 1) Nueva videoteca de películas             |");
        System.out.println("| 2) Configurar velocidad de reproducción     |");
        System.out.println("| 3) Añadir una nueva película a la videoteca |");
        System.out.println("| 4) Mostrar información actual de películas  |");
        System.out.println("| 5) Salir (se borrará toda la información)   |");
        System.out.println("|---------------------------------------------|");

        int opcion = Esdia.readInt("Seleccione una opción (1-5): ");

        switch (opcion) {
            case 1:
                int numPeliculas = Esdia.readInt("Introduza el número de películas:");
                videoteca.resetearPelicula(numPeliculas);
                videoteca.setPeliculas(new Pelicula[numPeliculas]);
                System.out.println("Sus películas han sido borradas.");
                System.out.printf("Nuevo tamaño: %d peliculas.", numPeliculas);
                break;
            case 2:
                float velocidad = Esdia.readFloat("Introduzca la nueva velocidad de reproducción:");
                videoteca.setVelocidadReproduccion(velocidad);
                System.out.printf("La nueva velocidad de reproducción es: %.2f\n", videoteca.getVelocidadReproduccion());
                break;
            
            case 3:
                // COMPROBAR QUE NO ESTÉ LLENO

                if (videoteca.isFull()) {
                    System.err.println("VIDEOTECA LLENA!!");
                } else {

                //PEDIR TODOS LOS DATOS
                System.out.println("Introduzca los datos de la película.");
                String titulo = Esdia.readString_ne("Título: ");
                int anioEstreno = Esdia.readInt("Año de estreno: ");
                int duracionMinutos = Esdia.readInt("Duración (min): ");;
                float valoracion = Esdia.readFloat("Valoración: ");;
                String nombre = Esdia.readString_ne("Nombre del director: ");
                String apellidos = Esdia.readString_ne("Apellidos del director: ");
                boolean oscarGanado = Esdia.yesOrNo("¿Ha ganado un óscar?: ");

                Pelicula p = Pelicula.crearPeliculaDatosCrudos(titulo, anioEstreno, duracionMinutos, valoracion, nombre, apellidos, oscarGanado);
                // LLAMAR A UN MÉTODO QUE AÑADA LA PELÍCULA
                if (videoteca.addPelicula(p)) {
                    System.out.println("Se ha añadido correectamente!");
                } else {
                    System.err.println("NO SE HA PODIDO AÑADIR!!");
                }

                // INFORMAR AL USUARIO SI TODO HA IDO BIEN 

                }
            

                break;
            case 4:
                videoteca.mostrarVideoteca(videoteca);
                break;
            case 5:
                continuar = false;
                System.out.println("Saliendo...");
                break;
            
            default:
                break;
        }

        }

    }

}
