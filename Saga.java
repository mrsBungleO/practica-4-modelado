import java.util.ArrayList;

/**
 * Clase concreta que representa al componente compuesto saga.
 */
public class Saga implements ComponenteRockBuster{

    /**Atributo que representa el nombre de la saga. */
    private String nombre;

    /**Atributo que representa el director de la saga. */
    private String director;

    /**Atributo que representa la duración de la saga. */
    private double duracion;

    /**Atributo que representa el genero de la saga. */
    private String genero;

    /**Atributo que representa la sinopsis o descripción de la saga. */
    private String sinopsis;

    /**Atributo que representa el precio de renta de la saga. */
    private double precioDeRenta;

    /**Atributo que representa a las peliculas o elementos asociados a la saga. */
    private ArrayList<ComponenteRockBuster> componentes;

    /**
     * Método constructor de una saga.
     * @param nombre el nombre de la saga.
     * @param director el director de la saga.
     * @param genero el genero de la saga.
     * @param sinopsis la sinopsis o descripción de la saga.
     * @param componentes las peliculas o elementos asociados a la saga.
     */
    public Saga(String nombre, String director, String genero, String sinopsis, ArrayList<ComponenteRockBuster> componentes){
        this.nombre= nombre;
        this.director= director;
        this.genero= genero;
        this.sinopsis= sinopsis;
        this.componentes= componentes;
        this.setDuracion(componentes);
        this.setPrecioDeRenta(componentes);
    }

    /**
     * Método que obtiene el nombre de la saga.
     * @return el nombre de la saga.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Método que obtiene el director de la saga.
     * @return el director de la saga
     */
    public String getDirector(){
        return director;
    }

    /**
     * Método que obtiene la duración de la saga.
     * @return la duración de la saga.
     */
    public double getDuracion(){
        return duracion;
    }

    /**
     * Método que obtiene el genero de la saga.
     * @return el genero de la saga.
     */
    public String getGenero(){
        return genero;
    }

    /**
     * Método que obtiene la sinopsis o descripción de la saga.
     * @return la sinopsis de la saga.
     */
    public String getSinopsis(){
        return sinopsis;
    }

    /**
     * Método que obtiene el precio de renta de la saga.
     * @return el precio de renta de la saga.
     */
    public double getPrecioDeRenta(){
        return precioDeRenta;
    }

    /**
     * Método que muestra en terminal la información de la saga.
     */
    public void mostrarInformacion(){

        System.out.println(this.getNombre() + "\nGenero: " + this.getGenero() + "\nDirector: " + this.getDirector());
        System.out.println("Contiene: ");

        for(ComponenteRockBuster componente: this.getComponentes()){
            System.out.println("*" + componente.getNombre());
        }

        System.out.println("Duración: " + this.getDuracion() + " min\n" + this.getSinopsis() + "\n$" + this.getPrecioDeRenta());
    
    }

    /**
     * Método que obtiene a las peliculas o elementos asociados a la saga.
     * @return los elementos asociados a la saga.
     */
    public ArrayList<ComponenteRockBuster> getComponentes(){
        return componentes;
    }

    /**
     * Método que establece la duración de una saga a partir de la duración de sus componentes.
     * @param componentes la estructura de datos que contiene a los elementos asociados a la saga.
     */
    public void setDuracion(ArrayList<ComponenteRockBuster> componentes){

        double duracion=0.0;

        for(ComponenteRockBuster componente: componentes){
            duracion+=componente.getDuracion();
        }

        this.duracion= duracion;
    }

    /**
     * Método que establece el precio de renta de la saga a partir del precio de renta de sus componentes, restandole un 5% de descuento.
     * @param componentes la estructura de datos que contiene a los elementos asociados a la saga.
     */
    public void setPrecioDeRenta(ArrayList<ComponenteRockBuster> componentes){
        double precio= 0.0;

        for(ComponenteRockBuster componente: componentes){
            precio+=componente.getPrecioDeRenta();
        }

        double descuento= (precio/100)*5;
        precio= precio-descuento;

        this.precioDeRenta= precio;
    }

    /**
     * Método que agrega elementos asociados a la saga.
     * @param componente un componente de tipo RockBuster.
     */
    public void agregar(ComponenteRockBuster componente){
        this.getComponentes().add(componente);
    }

    /**
     * Método que quita algun componente de nuestros elementos asociados a la saga.
     * @param componente un componente de tipo RockBuster.
     */
    public void remover(ComponenteRockBuster componente){
        this.getComponentes().remove(componente); 
    }
}