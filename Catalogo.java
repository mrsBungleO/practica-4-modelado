import java.util.ArrayList;

public class Catalogo{

    private ArrayList<ComponenteRockBuster> productos;

    public Catalogo(){
        this.productos = new ArrayList<>();
        this.cargarProductos();
    }

    public void agregarProducto(ComponenteRockBuster producto){
        this.productos.add(producto);
    }

    public ArrayList<ComponenteRockBuster> getProductos(){
        return productos;
    }

    public ArrayList<ComponenteRockBuster> filtrarPorGenero(String genero){
        ArrayList<ComponenteRockBuster> encontrados = new ArrayList<>();

        for(ComponenteRockBuster producto: this.getProductos()){
            if(producto.getGenero().equalsIgnoreCase(genero)){
                encontrados.add(producto);
            }
        }

        return encontrados;
    }

    public ArrayList<ComponenteRockBuster> filtrarPorCostoMaximo(double costoMaximo){
        ArrayList<ComponenteRockBuster> encontrados = new ArrayList<>();

        for(ComponenteRockBuster producto: this.getProductos()){
            if(producto.getPrecioDeRenta() <= costoMaximo){
                encontrados.add(producto);
            }
        }

        return encontrados;
    }

    public ArrayList<String> getGenerosDisponibles(){
        ArrayList<String> generos = new ArrayList<>();

        for(ComponenteRockBuster producto: this.getProductos()){
            String genero = producto.getGenero();
            boolean yaEsta = false;

            for(String existente: generos){
                if(existente.equalsIgnoreCase(genero)){
                    yaEsta = true;
                }
            }

            if(!yaEsta){
                generos.add(genero);
            }
        }

        return generos;
    }

    public void imprimirLista(ArrayList<ComponenteRockBuster> listaProductos){
        if(listaProductos.isEmpty()){
            System.out.println("No se encontraron productos.");
            return;
        }

        for(int i = 0; i < listaProductos.size(); i++){
            ComponenteRockBuster producto = listaProductos.get(i);
            System.out.println((i + 1) + ". " + producto.getNombre() + " - $" + String.format("%.2f", producto.getPrecioDeRenta()));
        }
    }

    private void cargarProductos(){

        Pelicula ep1 = new Pelicula("Star Wars Episodio I: La Amenaza Fantasma", "George Lucas", 136, "Ciencia Ficcion", "Un joven esclavo descubre que puede ser el elegido que traera equilibrio a la Fuerza.", 34.90);
        Pelicula ep2 = new Pelicula("Star Wars Episodio II: El Ataque de los Clones", "George Lucas", 142, "Ciencia Ficcion", "Un ejercito de clones se prepara mientras un lado oscuro crece en las sombras.", 34.90);
        Pelicula ep3 = new Pelicula("Star Wars Episodio III: La Venganza de los Sith", "George Lucas", 140, "Ciencia Ficcion", "La Republica cae y nace el Imperio.", 34.90);
        Pelicula ep4 = new Pelicula("Star Wars Episodio IV: Una Nueva Esperanza", "George Lucas", 121, "Ciencia Ficcion", "Un joven granjero se une a la rebelion para enfrentar al Imperio.", 39.90);
        Pelicula ep5 = new Pelicula("Star Wars Episodio V: El Imperio Contraataca", "Irvin Kershner", 124, "Ciencia Ficcion", "La rebelion sufre sus peores derrotas mientras se revela un secreto familiar.", 39.90);
        Pelicula ep6 = new Pelicula("Star Wars Episodio VI: El Retorno del Jedi", "Richard Marquand", 131, "Ciencia Ficcion", "La batalla final entre la rebelion y el Imperio.", 39.90);
        Pelicula rogueOne = new Pelicula("Rogue One: Una Historia de Star Wars", "Gareth Edwards", 133, "Accion", "Un grupo de rebeldes roba los planos de la estrella de la muerte.", 29.90);

        this.agregarProducto(ep1);
        this.agregarProducto(ep2);
        this.agregarProducto(ep3);
        this.agregarProducto(ep4);
        this.agregarProducto(ep5);
        this.agregarProducto(ep6);
        this.agregarProducto(rogueOne);

        ArrayList<ComponenteRockBuster> precuelas = new ArrayList<>();
        precuelas.add(ep1);
        precuelas.add(ep2);
        precuelas.add(ep3);
        Saga trilogiaPrecuelas = new Saga("Saga: Trilogia de Precuelas", "George Lucas", "Ciencia Ficcion", "Las tres peliculas que cuentan la caida de la Republica.", precuelas);

        ArrayList<ComponenteRockBuster> original = new ArrayList<>();
        original.add(ep4);
        original.add(ep5);
        original.add(ep6);
        Saga trilogiaOriginal = new Saga("Saga: Trilogia Original", "George Lucas", "Ciencia Ficcion", "La trilogia clasica que empezo todo.", original);

        this.agregarProducto(trilogiaPrecuelas);
        this.agregarProducto(trilogiaOriginal);

        DiscoMusical disco1 = new DiscoMusical("The Dark Side of the Moon", "Pink Floyd", "Rock Progresivo", 1973, 15.99);
        DiscoMusical disco2 = new DiscoMusical("Thriller", "Michael Jackson", "Pop", 1982, 14.50);
        DiscoMusical disco3 = new DiscoMusical("Back in Black", "AC/DC", "Rock", 1980, 13.75);

        DiscoMusical disco4 = new DiscoMusical("Abbey Road", "The Beatles", "Rock", 1969, 16.50);
        DiscoMusical disco5 = new DiscoMusical("Kind of Blue", "Miles Davis", "Jazz", 1959, 18.90);
        DiscoMusical disco6 = new DiscoMusical("Nevermind", "Nirvana", "Grunge", 1991, 14.20);
        DiscoMusical disco7 = new DiscoMusical("Random Access Memories", "Daft Punk", "Electronica", 2013, 19.99);
        DiscoMusical disco8 = new DiscoMusical("Un Verano Sin Ti", "Bad Bunny", "Reggaeton", 2022, 17.80);
        DiscoMusical disco9 = new DiscoMusical("Rumours", "Fleetwood Mac", "Pop", 1977, 15.30);

        this.agregarProducto(new DiscoAdapter(disco1));
        this.agregarProducto(new DiscoAdapter(disco2));
        this.agregarProducto(new DiscoAdapter(disco3));
        this.agregarProducto(new DiscoAdapter(disco4));
        this.agregarProducto(new DiscoAdapter(disco5));
        this.agregarProducto(new DiscoAdapter(disco6));
        this.agregarProducto(new DiscoAdapter(disco7));
        this.agregarProducto(new DiscoAdapter(disco8));
        this.agregarProducto(new DiscoAdapter(disco9));
    }

}