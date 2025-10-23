package modelo;

public class Pelicula {
    private String titulo;
    private int anioEstreno;
    private int duracionMinutos;
    private float valoracion;
    private Director director;
    private float velocidad;

    public Pelicula(String titulo, int anioEstreno, int duracionMinutos, float valoracion, Director director) {
        this.titulo = titulo;
        this.anioEstreno = anioEstreno;
        this.duracionMinutos = duracionMinutos;
        this.valoracion = valoracion;
        this.director = director;
        this.velocidad = 1;
    }

    public static Pelicula crearPeliculaDatosCrudos(String titulo, int anioEstreno, int duracionMinutos, float valoracion, String nombreDirector, String apellidosDirector, boolean oscarGanado) {
         Director director = new Director(nombreDirector, apellidosDirector, oscarGanado);
        Pelicula pelicula = new Pelicula(titulo, anioEstreno, duracionMinutos, valoracion, director);

        return pelicula;
    }

    public String obtenerPeliculaComoFila(float velocidadVideoteca) {
        return String.format(
            "%-15s|%-12d|%-20s|%-12s|%-15d|%-20.2f|%-10.1f",
            titulo,
            anioEstreno,
            director.getNombre() + " " + director.getApellidos(),
            director.isOscarGanado() ? "Sí" : "No",
            duracionMinutos,
            duracionMinutos / velocidadVideoteca,
            valoracion
        );
    }

    public float getTiempoVisionado() {
        return duracionMinutos / velocidad;
    }

    public String getTitulo() {
         return titulo; 
        }
    public void setTitulo(String titulo) {
         this.titulo = titulo; 
        }
    public int getAnioEstreno() { 
        return anioEstreno; 
    }
    public void setAnioEstreno(int anioEstreno) {
         this.anioEstreno = anioEstreno;
         }
    public int getDuracionMinutos() { 
        return duracionMinutos; 
    }
    public void setDuracionMinutos(int duracionMinutos) {
         this.duracionMinutos = duracionMinutos; 
        }
    public float getValoracion() { 
        return valoracion; 
    }
    public void setValoracion(float valoracion) {
        this.valoracion = valoracion; 
    }
    public Director getDirector() {
         return director; 
        }
    public void setDirector(Director director) {
         this.director = director; 
        }
    public float getVelocidad() {
         return velocidad; 
        }
    public void setVelocidad(float velocidad) {
         this.velocidad = velocidad;
         }
}