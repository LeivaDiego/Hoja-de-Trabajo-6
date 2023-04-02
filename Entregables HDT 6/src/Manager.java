import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Manager {

    //Propiedades del controlador de la tienda
    private Map<String, Product> inventory = null;
    private Map<String, Product> collection = null;
    private ArrayList<String> inventory_keys;
    private ArrayList<String> collection_keys;


    /**
     * Instancia el map y crea la tienda en linea
     * @param option opcion seleccionada
     * @throws FileNotFoundException
     */
    public Manager(int option) throws FileNotFoundException {
        try{
            inventory = (new MapFactory<String, Product>()).createMap(option);
            collection = (new MapFactory<String, Product>()).createMap(option);
            inventory_keys = new ArrayList<String>();
            collection_keys = new ArrayList<String>();
            read();
        }catch(FileNotFoundException e){
            String str = e.getMessage();
            throw new FileNotFoundException(str);
        }
    }

    /**
     * Lectura del archivo de texto que contiene la información de los productos
     * @throws FileNotFoundException si no se encuentra el archivo
     */
    private void read() throws FileNotFoundException{
        try{
            File file = new File("C:/Users/diego/Documents/UVG/5to Semestre/Algoritmos y Estructuras de Datos/Hoja-de-Trabajo-6/Tiende Online/src/ListadoProducto.txt");
            Scanner input = new Scanner(file);
            while(input.hasNextLine()){
                String[] elements = input.nextLine().split("[|]");
                String category = elements[0].trim();
                String nameProduct = elements[1].trim();
                insertProduct(category, nameProduct, inventory, inventory_keys);
            }
            input.close();
        }catch(FileNotFoundException e){
            String str =  e.getMessage();
            throw new FileNotFoundException(str);
        }
    }


    /**
     * Añade un producto a la colleccion del usuario en caso
     * el producto exista
     * @param category categoria del producto
     * @param nameProduct nombre del producto
     * @return el estado del producto
     */
    public String newProduct(String category, String nameProduct){
        String status = "";
        Product product = null;
        String key = createKey1(category, nameProduct);
        Boolean add = true;

        if(collection.containsKey(key)){
            product = inventory.get(key);
            product.addAmount();
            collection.remove(key);
            collection.put(key, product);
        }
        else{
            if (inventory.containsKey(key))
                insertProduct(category, nameProduct, collection, collection_keys);
            else{
                status = "El producto: " + nameProduct + " no existe";
                add = false;
            }
        }
        if(add)
            status = "Añadiendo: " + nameProduct;
        return status;
    }

    /**
     * Busqueda de la categoría del producto que el usuario desea
     * @param nameProduct el nombre del producto
     * @return la categoria del producto
     */
    public String searchCategory(String nameProduct){
        String category = "";
        Boolean search = false;
        String[] keys = {};

        for(int i = 0; i < this.inventory_keys.size() && search == false; i++){
            keys = this.inventory_keys.get(i).split("[|]");
            if (keys[1].equals(nameProduct)){
                category = keys[0];
                search = true;
            }
        }
        return "La categoría es: " + category;
    }


    /**
     * Muestra en pantalla la informacion del producto dependiendo de la opcion elegida por el usuario
     * @Overload
     * @param option    opcion seleccionada por el usuario
     * @param mapOption opcion de implementacion de mapa
     * @return todos los productos
     */
    public String showProducts(int option, int mapOption){
        String products = "";

        switch (option){
            case 3:
                products = "Categoria | Producto | Cantidad \n";
                products += showProduct1(collection_keys, collection, option);
            case 4:
                products = "Categoria | Producto | Cantidad \n";
                products += showProduct2(collection_keys, collection, mapOption, option);
            case 5:
                products = "Categoria | Producto \n";
                products += showProduct1(inventory_keys, inventory, option);
            case 6:
                products = "Categoria | Producto \n";
                products += showProduct2(inventory_keys, inventory, mapOption, option);
        }
        return products;
    }


    /**
     * Muestra la informacion de los productos
     * @Overload
     * @param keys identificadores de productos
     * @return todos los productos
     */
    private String showProduct1(ArrayList<String> keys, Map<String, Product> map, int option){
        String products = "";
        for(int i = 0; i < keys.size(); i++){
            Product product = map.get(keys.get(i));
            products += product.toString(option) + "\n";
        }
        return products;
    }


    /**
     * Muestra la informacion del producto ordenada por tipo
     * @Overload
     * @param keys identificadores de productos
     * @param map   el map usado
     * @param mapOption la implementacion de map usada
     * @return todos los productos
     */
    private String showProduct2(ArrayList<String> keys, Map<String, Product> map, int mapOption, int option){
        String products = "";
        List<Entry<String, Product>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByKey());
        Map<String, Product> result = new LinkedHashMap<>();
        for(Entry<String, Product> entry : list){
            result.put(entry.getKey(), entry.getValue());
            products += entry.getValue().toString(option) + "\n";
        }
        return products;
    }


    /**
     * Inserta un producto en el map
     * @param category categoria del producto
     * @param product_name   nombre del producto
     * @param map   mapa
     * @param keys  identificadores
     */
    private void insertProduct(String category, String product_name, Map<String, Product> map, ArrayList<String> keys){
        Product product = new Product(product_name, category);
        String key = createKey2(category, product_name, keys);
        map.put(key, product);
    }


    /**
     * Crea una llave que sera el identificador del producto
     * @Overload
     * @param category categoria del producto
     * @param product   el producto
     * @return una llave que el map utiiza
     */
    private String createKey1(String category, String product){
        String key = category.trim()  + "|" + product.trim();
        return key;
    }


    /**
     * Crea una llave que sera el ID del producto y lo agrega a un array
     * @Overload
     * @param category la categoria del producto
     * @param product   el producto
     * @return una llave que el map utiliza
     */
    private String createKey2(String category, String product, ArrayList<String> keys){
        String key = category.trim() + "|" + product.trim();
        keys.add(key);
        return key;
    }
}
