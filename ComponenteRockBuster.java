/**
 * Interfaz que define un comportamiento para los componentes (peliculas,sagas) de la compañia RockBuster.
 */
public interface ComponenteRockBuster{

    /**
     * Método para obtener el nombre del componente.
     */
    public String getNombre();

    /**
     * Método para obtener al director del componente.
     */
    public String getDirector();

    /**
     * Método para obtener la duracion del componente en minutos.
     */
    public double getDuracion();

    /**
     * Método para obtener el genero del componente.
     */
    public String getGenero();

    /**
     * Método para obtener la sinopsis del componente.
     */
    public String getSinopsis();

    /**
     * Método para obtener el precio de renta del componente.
     */
    public double getPrecioDeRenta();

    /**
     * Método para mostrar la información del componente.
     */
    public void mostrarInformacion();

}