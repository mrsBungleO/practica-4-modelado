/**
 * Disco Musical de la tienda Mixdown
 * Esta clase conserva su propia interfaz y no se modifica
 */
public class DiscoMusical {

    /** Nombre del disco */
    private String nombre;

    /** Artista del disco */
    private String artista;

    /** Genero musical del disco */
    private String generoMusical;

    /** Anio del estreno del disco */
    private int anioDeEstreno;

    /** Precio de venta del disco */
    private double precioDeVenta;

    /**
     * Construye el disco musical
     * @param nombre nombre del disco
     * @param artista artista del disco
     * @param generoMusical genero musical del disco
     * @param anioDeEstreno anio de estrenos del disco
     * @param precioDeVenta precio de venta del disco
     */
    public DiscoMusical (String nombre, String artista, String generoMusical, int anioDeEstreno, double precioDeVenta){
        this.nombre = nombre;
        this.artista = artista;
        this.generoMusical = generoMusical;
        this.anioDeEstreno = anioDeEstreno;
        this.precioDeVenta = precioDeVenta;
    }

     /** @return el nombre del disco. */
    public String getNombre() { 
        return nombre; 
    }

    /** @return el artista del disco. */
    public String getArtista() { 
        return artista; 
    }

    /** @return el genero musical del disco. */
    public String getGeneroMusical() { 
        return generoMusical; 
    }

    /** @return el anio de estreno del disco. */
    public int getAnioDeEstreno() { 
        return anioDeEstreno;
    }

    /** @return el precio de venta del disco. */
    public double getPrecioDeVenta() { 
        return precioDeVenta; 
    }

}
