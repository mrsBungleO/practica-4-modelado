import java.util.ArrayList;

/**
 * Aqui se guardan todos los productos de RockBuster en una sola lista: peliculas,
 * sagas y discos de musica. Tambien sabe responder lo que un cliente quiere
 * consultar, como buscar por genero o por precio.
 */
public class Catalogo{

    /**Lista donde viven todos los productos de la tienda. */
    private ArrayList<ComponenteRockBuster> productos;

    /**
     * Crea el catalogo y lo llena de una vez con los productos de la tienda.
     */
    public Catalogo(){
        this.productos = new ArrayList<>();
        this.cargarProductos();
    }

    /**
     * Mete un producto nuevo al catalogo. Sirve igual para una pelicula, una saga
     * o un disco, porque para el catalogo todos son lo mismo.
     * @param producto el producto que se quiere agregar.
     */
    public void agregarProducto(ComponenteRockBuster producto){
        this.productos.add(producto);
    }

    /**
     * Entrega la lista con todos los productos de la tienda.
     * @return todos los productos del catalogo.
     */
    public ArrayList<ComponenteRockBuster> getProductos(){
        return productos;
    }

    /**
     * Busca los productos que son de un genero. Da igual si el genero se escribe
     * con mayusculas o minusculas.
     * @param genero el genero que se esta buscando.
     * @return los productos que son de ese genero.
     */
    public ArrayList<ComponenteRockBuster> filtrarPorGenero(String genero){
        ArrayList<ComponenteRockBuster> encontrados = new ArrayList<>();

        for(ComponenteRockBuster producto: this.getProductos()){
            if(producto.getGenero().equalsIgnoreCase(genero)){
                encontrados.add(producto);
            }
        }

        return encontrados;
    }

    /**
     * Busca los productos que cuestan lo mismo o menos que una cantidad.
     * @param costoMaximo lo maximo que el cliente quiere pagar.
     * @return los productos que cuestan ese precio o menos.
     */
    public ArrayList<ComponenteRockBuster> filtrarPorCostoMaximo(double costoMaximo){
        ArrayList<ComponenteRockBuster> encontrados = new ArrayList<>();

        for(ComponenteRockBuster producto: this.getProductos()){
            if(producto.getPrecioDeRenta() <= costoMaximo){
                encontrados.add(producto);
            }
        }

        return encontrados;
    }

    /**
     * Junta los generos que hay en la tienda, sin repetir ninguno. Sirve para
     * mostrarle al cliente las opciones que puede elegir al filtrar por genero.
     * @return la lista de generos disponibles, tanto de peliculas como de discos.
     */
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

    /**
     * Imprime una lista de productos con un numero, su nombre y su precio. Asi el
     * cliente puede escoger uno despues para ver todos sus datos.
     * @param listaProductos los productos que se quieren mostrar.
     */
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

    /**
     * Crea los productos de la tienda y los mete al catalogo: primero las peliculas
     * sueltas, luego las sagas armadas con esas peliculas (incluida una saga grande
     * que junta a otras sagas y peliculas) y al final los discos de musica, que se
     * meten con su adaptador para que el catalogo los trate igual.
     */
    private void cargarProductos(){

        Pelicula ep1 = new Pelicula("Star Wars Episodio I: La Amenaza Fantasma", "George Lucas", 136, "Ciencia Ficcion", "Un joven esclavo descubre que puede ser el elegido que traera equilibrio a la Fuerza.", 34.90);
        Pelicula ep2 = new Pelicula("Star Wars Episodio II: El Ataque de los Clones", "George Lucas", 142, "Ciencia Ficcion", "Un ejercito de clones se prepara mientras un lado oscuro crece en las sombras.", 34.90);
        Pelicula ep3 = new Pelicula("Star Wars Episodio III: La Venganza de los Sith", "George Lucas", 140, "Ciencia Ficcion", "La Republica cae y nace el Imperio.", 34.90);
        Pelicula ep4 = new Pelicula("Star Wars Episodio IV: Una Nueva Esperanza", "George Lucas", 121, "Ciencia Ficcion", "Un joven granjero se une a la rebelion para enfrentar al Imperio.", 39.90);
        Pelicula ep5 = new Pelicula("Star Wars Episodio V: El Imperio Contraataca", "Irvin Kershner", 124, "Ciencia Ficcion", "La rebelion sufre sus peores derrotas mientras se revela un secreto familiar.", 39.90);
        Pelicula ep6 = new Pelicula("Star Wars Episodio VI: El Retorno del Jedi", "Richard Marquand", 131, "Ciencia Ficcion", "La batalla final entre la rebelion y el Imperio.", 39.90);
        Pelicula ep7 = new Pelicula("Star Wars Episodio VII: El Despertar de la Fuerza", "J.J. Abrams", 136, "Ciencia Ficcion", "El terrible y enigmático guerrero Kylo Ren ha reunido un ejército de leales al Imperio, que se hace llamar la Primera Orden y ataca a la Alianza.", 34.90);
        Pelicula ep8 = new Pelicula("Star Wars Episodio VIII: Los Ultimos Jedi", "Rian Johnson", 152, "Ciencia Ficcion", "Rey se encuentra lejos, intentando convencer a Luke Skywalker de que la entrene y la convierta en la última Jedi.", 30.0);
        Pelicula ep9 = new Pelicula("Star Wars Episodio IX: El Ascenso de Skywalker", "J.J Abrams", 142, "Ciencia Ficcion", "Finn y Poe guían a la Resistencia para detener los planes de la Primera Orden para formar un nuevo imperio, mientras Rey anticipa un enfrentamiento inevitable con Kylo Ren.", 30.0);
        Pelicula rogueOne = new Pelicula("Rogue One: Una Historia de Star Wars", "Gareth Edwards", 133, "Accion", "Un grupo de rebeldes roba los planos de la estrella de la muerte.", 29.90);

        this.agregarProducto(ep1);
        this.agregarProducto(ep2);
        this.agregarProducto(ep3);
        this.agregarProducto(ep4);
        this.agregarProducto(ep5);
        this.agregarProducto(ep6);
        this.agregarProducto(ep7);
        this.agregarProducto(ep8);
        this.agregarProducto(ep9);
        this.agregarProducto(rogueOne);

        ArrayList<ComponenteRockBuster> precuelas = new ArrayList<>();
        precuelas.add(ep1);
        precuelas.add(ep2);
        precuelas.add(ep3);
        Saga trilogiaPrecuelas = new Saga("Saga: Trilogia de Precuelas de Star Wars", "George Lucas", "Ciencia Ficcion", "Las tres peliculas que cuentan la caida de la Republica.", precuelas);

        ArrayList<ComponenteRockBuster> original = new ArrayList<>();
        original.add(ep4);
        original.add(ep5);
        original.add(ep6);
        Saga trilogiaOriginal = new Saga("Saga: Trilogia Original de Star Wars", "George Lucas, Irvin Kershner, Richard Marquand", "Ciencia Ficcion", "La trilogia clasica que empezo todo.", original);

        ArrayList<ComponenteRockBuster> secuelas = new ArrayList<>();
        secuelas.add(ep7);
        secuelas.add(ep8);
        secuelas.add(ep9);
        Saga trilogiaSecuelas = new Saga("Saga: Trilogia de Secuelas de Star Wars", "J.J. Abrams y Rian Johnson", "Ciencia Ficcion", "Una nueva generación de héroes y la Resistencia se alzan contra la tiránica Primera Orden, mientras la chatarrera Rey y el corrompido Kylo Ren se disputan el destino de la Fuerza.", secuelas);

        ArrayList<ComponenteRockBuster> universoStarWars = new ArrayList<>();
        universoStarWars.add(trilogiaPrecuelas);
        universoStarWars.add(rogueOne);
        universoStarWars.add(trilogiaOriginal);
        universoStarWars.add(trilogiaSecuelas);

        Saga starWars = new Saga("Saga: Universo Star Wars", "George Lucas, Irvin Kershner, Richard Marquand, Gareth Edwards, J.J. Abrams y Rian Johnson",
        "Ciencia Ficcion","Todas las historias del universo Star Wars de principio a fin.", universoStarWars);

        this.agregarProducto(trilogiaPrecuelas);
        this.agregarProducto(trilogiaOriginal);
        this.agregarProducto(trilogiaSecuelas);
        this.agregarProducto(starWars);

        DiscoMusical disco1 = new DiscoMusical("The Dark Side of the Moon", "Pink Floyd", "Rock Progresivo", 1973, 15.99);
        DiscoMusical disco2 = new DiscoMusical("Thriller", "Michael Jackson", "Pop", 1982, 14.50);
        DiscoMusical disco3 = new DiscoMusical("Back in Black", "AC/DC", "Rock", 1980, 13.75);

        DiscoMusical disco4 = new DiscoMusical("Abbey Road", "The Beatles", "Rock", 1969, 16.50);
        DiscoMusical disco5 = new DiscoMusical("Kind of Blue", "Miles Davis", "Jazz", 1959, 18.90);
        DiscoMusical disco6 = new DiscoMusical("Nevermind", "Nirvana", "Grunge", 1991, 14.20);
        DiscoMusical disco7 = new DiscoMusical("Random Access Memories", "Daft Punk", "Electronica", 2013, 19.99);
        DiscoMusical disco8 = new DiscoMusical("Un Verano Sin Ti", "Bad Bunny", "Reggaeton", 2022, 17.80);
        DiscoMusical disco9 = new DiscoMusical("Rumours", "Fleetwood Mac", "Pop", 1977, 15.30);
        DiscoMusical disco10 = new DiscoMusical("Right Place, Wrong Person", "RM", "Hip Hop", 2024, 18.50);

        this.agregarProducto(new DiscoAdapter(disco1));
        this.agregarProducto(new DiscoAdapter(disco2));
        this.agregarProducto(new DiscoAdapter(disco3));
        this.agregarProducto(new DiscoAdapter(disco4));
        this.agregarProducto(new DiscoAdapter(disco5));
        this.agregarProducto(new DiscoAdapter(disco6));
        this.agregarProducto(new DiscoAdapter(disco7));
        this.agregarProducto(new DiscoAdapter(disco8));
        this.agregarProducto(new DiscoAdapter(disco9));
        this.agregarProducto(new DiscoAdapter(disco10));
    }

}