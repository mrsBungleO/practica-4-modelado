/**
 * Clase concreta que representa al componente pelicula.
 */
public class Pelicula implements ComponenteRockBuster{

    /**Atributo que representa el nombre de la pelicula.*/
    private String nombre;

    /**Atributo que representa el director de la pelicula.*/
    private String director;

    /**Atributo que representa la duración de la película en minutos.*/
    private double duracion;

    /**Atributo que representa el genero de la pelicula.*/
    private String genero;

    /**Atributo que representa la sinopsis o descripción de la película.*/
    private String sinopsis;

    /**Atributo que representa el precio de renta de la película.*/
    private double precioDeRenta;

    /**
     * Método constructor para una película.
     * @param nombre el nombre de la pelicula.
     * @param director el director de la pelicula.
     * @param duracion la duracion de la pelicula en minutos.
     * @param genero el genero de la pelicula.
     * @param sinopsis la sinopsisi o descripcion de la pelicula.
     * @param precioDeRenta el precio de renta de la pelicula.
     */
    public Pelicula(String nombre, String director, double duracion, String genero, String sinopsis, double precioDeRenta){
        this.nombre= nombre;
        this.director= director;
        this.duracion= duracion;
        this.genero= genero;
        this.sinopsis= sinopsis;
        this.precioDeRenta= precioDeRenta;
    }

    /**
     * Método que obtiene el nombre de la película.
     * @return el nombre de la pelicula.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Método que devuelve el director de la película.
     * @return el director de la pelicula.
     */
    public String getDirector(){
        return director;
    }

    /**
     * Método que devuelve la duración de la pelicula en minutos.
     * @return la duración de la pelicula.
     */
    public double getDuracion(){
        return duracion;
    }

    /**
     * Método que devuelve el genero de la película.
     * @return el genero de la pelicula.
     */
    public String getGenero(){
        return genero;
    }

    /**
     * Método que devuelve la sinopsis de la película.
     * @return la sinopsis o descripción de la película.
     */
    public String getSinopsis(){
        return sinopsis;
    }

    /**
     * Método que devuelve el precio de renta de la película.
     * @return el precio de renta de la película.
     */
    public double getPrecioDeRenta(){
        return precioDeRenta;
    }

    /**
     * Método que muestra en terminal la información de la película.
     */
    public void mostrarInformacion(){
        System.out.println(this.getNombre() + "\nGenero: " + this.getGenero() + "\nDirector: " + this.getDirector() + "\nDuración: " + this.getDuracion() + " min\n" + this.getSinopsis() + "\n$" + this.getPrecioDeRenta());
    }
}