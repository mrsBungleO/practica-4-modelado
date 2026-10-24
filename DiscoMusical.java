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

     /** 
      * Metodo que obtiene el nombre del disco
      * @return el nombre del disco 
      */
    public String getNombre() { 
        return nombre; 
    }

    /**
     * Metodo que obtiene el artista del disco
     *  @return el artista del disco. 
     */
    public String getArtista() { 
        return artista; 
    }

    /** 
     * Metodo que obtiene el genero musical
     * @return el genero musical del disco. 
     */
    public String getGeneroMusical() { 
        return generoMusical; 
    }

    /** 
     * Metodo que obtiene el añio de estreno del disco
     * @return el anio de estreno del disco. 
     */
    public int getAnioDeEstreno() { 
        return anioDeEstreno;
    }

    /** 
     * Metodo que obtiene el precio de venta del disco
     * @return el precio de venta del disco. 
     */
    public double getPrecioDeVenta() { 
        return precioDeVenta; 
    }

}
