import java.util.ArrayList;

public class Catalogo{

    public static void main(String[] args){

        Pelicula pelicula1= new Pelicula("Tres lancheros bien pikudos", "armando zayas", 69.69, "ficheras", "rjfnifj,fk", 20.90);
        Pelicula pelicula2= new Pelicula("La toalla del mojado", "Frankie Rivers", 120.00,"accion","jcneioudhuydn", 19.56);

        pelicula1.mostrarInformacion();
        System.out.println("");
        pelicula2.mostrarInformacion();
        System.out.println("");


        ArrayList<ComponenteRockBuster> componentes = new ArrayList<>();
        componentes.add(pelicula1);
        componentes.add(pelicula2);

        Saga saga1= new Saga("Las mas chingonas", "yo", "accion", "kmfoijfokf32o", componentes);
        saga1.mostrarInformacion();

    }
}