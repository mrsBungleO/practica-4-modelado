import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        Catalogo catalogo = new Catalogo();
        Scanner lector = new Scanner(System.in);

        System.out.println("\n_________ BIENVENIDO AL CATALOGO DE ROCKBUSTER _________\n");

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
                    lector.nextLine();
                    System.out.print("\n¿Que genero buscas? ");
                    String genero = lector.nextLine().trim();
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