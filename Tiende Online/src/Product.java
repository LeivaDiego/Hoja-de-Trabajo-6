/**
 * Clase que modela al objeto "producto"
 * @author diego leiva
 */
public class Product {
    // Propiedades del modelo Producto
    private String name;
    private String category;
    private int qty;


    /**
     * Constructor
     * @param name el nombre del producto
     * @param category  la categoria del producto
     */
    public Product(String name, String category){
        this.name = name;
        this.category = category;
        this.qty = 1;
    }


    /**
     * Incrementa la cantidad de producto especifico
     */
    public void addAmount(){
        this.qty++;
    }


    /**
     * Crea una cadena que contiene la informacion del producto
     * @param option la opcion seleccionada
     * @return un string
     */
    public String toString(int option){
        String string = "";
        if (option == 3 || option == 4)
            string = this.category + " | " + this.name + " | " + this.qty;
        else if (option == 5 || option == 6)
            string = this.category + " | " + this.name;
        return string;
    }
}
