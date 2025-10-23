package modelo;

public class Videoteca {

    private Pelicula[] peliculas;
    private int contadorPeliculas;
    private float velocidad;

    public Videoteca(int numPeliculas) {
        peliculas = new Pelicula[numPeliculas];
        velocidad = 1;
    }

    public void resetearPelicula(int numPeliculas) {
        peliculas = new Pelicula[numPeliculas];
        contadorPeliculas = 0;
    }

    public boolean addPelicula(Pelicula p) {
        if (!isFull()) {
            peliculas[contadorPeliculas] = p;
            contadorPeliculas++;
            return true;
        }
        return false;
    }

    public boolean setVelocidadReproduccion(float velocidad) {
        this.velocidad = velocidad;
        return true;
    }

    public void mostrarVideoteca(Videoteca videoteca) {
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("| PELÍCULAS EN LA VIDEOTECA                                                                                                     |");
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("| Título         | Año Estreno | Director            | Oscar ganado | Duración (min) | Tiempo visionado (min) | Valoración |");
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");

        double tiempoTotal = 0;
        double valoracionTotal = 0;

        for (int i = 0; i < contadorPeliculas; i++) {
            Pelicula p = peliculas[i];
            System.out.println(p.obtenerPeliculaComoFila(velocidad));
            tiempoTotal += p.getDuracionMinutos() / velocidad;
            valoracionTotal += p.getValoracion();
        }

        double valoracionMedia = (contadorPeliculas > 0) ? valoracionTotal / contadorPeliculas : 0;

        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("| Tiempo de visionado total de la videoteca: %.2f min |%n", tiempoTotal);
        System.out.printf("| Valoración total de la videoteca: %.2f |%n", valoracionMedia);
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
    }

    public boolean isFull() {
        return contadorPeliculas >= peliculas.length;
    }

    public int getContadorPeliculas()
     { 
        return contadorPeliculas; 
    }
    public float getVelocidadReproduccion() {
         return velocidad; 
    }
    public Pelicula[] getPeliculas() {
         return peliculas; 
        }
    public void setPeliculas(Pelicula[] peliculas) {
         this.peliculas = peliculas; 
        }
}
