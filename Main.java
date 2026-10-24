import java.util.ArrayList;
import java.util.Scanner;

/**
 * Es la clase que se corre para usar el catalogo de RockBuster. Muestra un menu
 * donde el cliente puede ver todo lo que hay, buscar por genero o por precio, y
 * elegir un producto para ver todos sus datos.
 */
public class Main{

    /**
     * Arranca el programa. Muestra el menu una y otra vez hasta que el cliente
     * escoge salir.
     * @param args datos que se le pueden pasar al programa desde la terminal (aqui no se usan).
     */
    public static void main(String[] args){

        Catalogo catalogo = new Catalogo();
        Scanner lector = new Scanner(System.in);

        System.out.println("\n-_-_-_-_- BIENVENIDO AL CATALOGO DE ROCKBUSTER -_-_-_-_-\n");

        boolean salir = false;

        while(!salir){
            System.out.println("\n¿Que quieres hacer?");
            System.out.println("1) Ver el catalogo completo");
            System.out.println("2) Filtrar por genero");
            System.out.println("3) Filtrar por un costo maximo");
            System.out.println("4) Salir");
            System.out.print("Elige una opcion (1-4): ");

            int opcion = leerOpcion(lector, 1, 4);

            switch(opcion){
                case 1:
                    mostrarYSeleccionar(catalogo.getProductos(), lector);
                    break;
                case 2:
                    ArrayList<String> generos = catalogo.getGenerosDisponibles();
                    System.out.println("\nGeneros disponibles (peliculas, sagas y discos):");
                    for(int i = 0; i < generos.size(); i++){
                        System.out.println((i + 1) + ") " + generos.get(i));
                    }
                    System.out.print("Elige un genero (1-" + generos.size() + "): ");
                    int numGenero = leerOpcion(lector, 1, generos.size());
                    String genero = generos.get(numGenero - 1);
                    ArrayList<ComponenteRockBuster> porGenero = catalogo.filtrarPorGenero(genero);
                    mostrarYSeleccionar(porGenero, lector);
                    break;
                case 3:
                    System.out.print("\n¿Cual es el costo maximo que quieres pagar? ");
                    double costoMaximo = leerCosto(lector);
                    ArrayList<ComponenteRockBuster> porCosto = catalogo.filtrarPorCostoMaximo(costoMaximo);
                    mostrarYSeleccionar(porCosto, lector);
                    break;
                default:
                    salir = true;
                    System.out.println("\n¡Gracias por visitar RockBuster!");
                    break;
            }
        }

    }

    /**
     * Muestra una lista de productos con su nombre y precio, y luego le pregunta
     * al cliente si quiere ver todos los datos de alguno. Si escribe 0, regresa
     * al menu sin mostrar nada mas.
     * @param productos los productos que se van a mostrar.
     * @param lector lo que se usa para leer lo que el cliente escribe.
     */
    private static void mostrarYSeleccionar(ArrayList<ComponenteRockBuster> productos, Scanner lector){
        System.out.println("");

        if(productos.isEmpty()){
            System.out.println("No se encontraron productos.");
            return;
        }

        for(int i = 0; i < productos.size(); i++){
            ComponenteRockBuster producto = productos.get(i);
            System.out.println((i + 1) + ". " + producto.getNombre() + " - $" + String.format("%.2f", producto.getPrecioDeRenta()));
        }

        System.out.print("\nEscribe el numero de un producto para ver su informacion completa, o 0 para regresar al menu: ");
        int indice = leerOpcion(lector, 0, productos.size());

        if(indice != 0){
            System.out.println("");
            productos.get(indice - 1).mostrarInformacion();
        }
    }

    /**
     * Pide un numero que este entre un minimo y un maximo. Si el cliente escribe
     * algo que no es un numero o que se sale del rango, se lo vuelve a pedir
     * hasta que lo escriba bien.
     * @param lector lo que se usa para leer lo que el cliente escribe.
     * @param minimo el numero mas chico que se acepta.
     * @param maximo el numero mas grande que se acepta.
     * @return el numero que el cliente escribio, ya revisado.
     */
    private static int leerOpcion(Scanner lector, int minimo, int maximo){
        int opcion = minimo - 1;

        while(opcion < minimo || opcion > maximo){
            if(lector.hasNextInt()){
                opcion = lector.nextInt();
                if(opcion < minimo || opcion > maximo){
                    System.out.print("Esa opcion no existe, intenta de nuevo: ");
                }
            } else {
                System.out.print("Eso no es un numero, intenta de nuevo: ");
                lector.next();
            }
        }

        return opcion;
    }

    /**
     * Pide el precio maximo que el cliente quiere pagar. Si escribe algo que no
     * es un numero o un numero negativo, se lo vuelve a pedir.
     * @param lector lo que se usa para leer lo que el cliente escribe.
     * @return el precio maximo que el cliente escribio, ya revisado.
     */
    private static double leerCosto(Scanner lector){
        double costo = -1;

        while(costo < 0){
            if(lector.hasNextDouble()){
                costo = lector.nextDouble();
                if(costo < 0){
                    System.out.print("El costo no puede ser negativo, intenta de nuevo: ");
                }
            } else {
                System.out.print("Eso no es un numero, intenta de nuevo: ");
                lector.next();
            }
        }

        return costo;
    }

}