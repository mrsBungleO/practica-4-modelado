/**
 * Adapter que permite tratar a DiscoMusical como un 
 * ComponenteRockBuster, para que el catalogo no distinga entre pelis y discos
 */
public class DiscoAdapter implements ComponenteRockBuster{

    /** Disco musical adaptado */
    private DiscoMusical disco;

    /**
     * Construye un adaptador a partir de un disco musical
     * @param disco el disco de MIxdown qur se va a adaptar
     */
    public DiscoAdapter(DiscoMusical disco){
        this.disco = disco;
    }

     /**
      * Metodo que obtiene el nombre del disco
      * @return el nombre del disco 
      */
    @Override
    public String getNombre(){
        return disco.getNombre();
    }

    /**
     * Metodo que obtiene al artista, que cumple el rol de director
     * @return el artista, que cumple el rol de director 
     */
    @Override
    public String getDirector(){
        return disco.getArtista();
    }

      /** 
       * Metodo que obtiene la duracion del disco
       * @return 0, porque los discos no tienen duracion registrada 
       */
    @Override
    public double getDuracion(){
        return 0;
    }

    /**
     * Metodo que obtiene el genero del disco
     * @return el genero musical del disco 
     * */
    @Override
    public String getGenero(){
        return disco.getGeneroMusical();
    }

    /** 
     * Metodo que obtiene la sinopsis del disco, armada con el artista
     * y el anio de estreno
     * @return una sinopsis armada con el artista y el anio de estreno 
     */
    @Override
    public String getSinopsis(){
        return "Disco de " + disco.getArtista() + ", estrenado en " + disco.getAnioDeEstreno();
    }

     /**
      * Metodo que obtiene el precio del disco
      * @return el precio de venta del disco
      */
    @Override
    public double getPrecioDeRenta(){
        return disco.getPrecioDeVenta();
    }

     /** 
      * Imprime la informacion completa del disco 
      * */
    @Override
    public void mostrarInformacion(){
        System.out.println("Nombre: " + getNombre());
        System.out.println("Artista: " + getDirector());
        System.out.println("Genero: " + getGenero());
        System.out.println("Descripcion: " + getSinopsis());
        System.out.println("Precio de renta: $" + getPrecioDeRenta());
    }
    

}
