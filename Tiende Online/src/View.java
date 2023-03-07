import java.util.InputMismatchException;
import java.util.Scanner;
public class View {
    //Propiedades
    private Scanner input;


    /**
     * Constructor de la vista
     */
    public View(){
        input = new Scanner(System.in);
    }


    /**
     * Si hay error muestra un mensaje en pantalla
     * @param s el mensaje
     */
    public void error(String s){
        System.out.println(s);
    }


    /**
     * Muestra en pantalla el mensaje de bienvenida
     */
    public void welcome(){
        System.out.println("Bienvenido al programa de tienda Online\n");
    }


    /**
     * Solicita el tipo de implementacion de map a utilizar
     * al usuario
     * @return el numero de la implementacion
     * @throws InputMismatchException si se ingresan datos no numericos
     * @throws Exception
     */
    public int mapOption() throws InputMismatchException, Exception{
        int option = -1;
        boolean flag = false;

        try{
            //MENU de implementacion de mapas
            System.out.println("Seleccione la opcion para la implementacion del mapa\n");
            System.out.println("[1.] Hash Map");
            System.out.println("[2.] Tree Map");
            System.out.println("[3.] Linked Hash Map\n");

            while (!flag){
                option = Integer.parseInt(input.nextLine());
                System.out.println();
                if (option > 0 && option <= 3)
                    flag = true;
                else{
                    System.out.println("ERROR");
                }
            }
        } catch (InputMismatchException e){
            String s = "ERROR" + option + ": " + e.toString();
            throw new InputMismatchException(s);
        } catch (Exception e){
            String s = "ERROR" +  option + ": " + e.toString();
            throw new Exception(s);
        }
        return option;
    }


    /**
     * Solicita al usuario que acciones desea realizar
     * @return el numero de opcion
     * @throws InputMismatchException si se ingresan datos no numericos
     * @throws Exception
     */
    public int menu() throws InputMismatchException, Exception{
        int option = -1;
        boolean flag = false;

        try{
            //Option's Menu
            System.out.println("Seleccione la accion que desea realizar\n");
            System.out.println("[1.] Añadir producto a la coleccion");
            System.out.println("[2.] Mostrar categoria de producto");
            System.out.println("[3.] Mostrar todos los productos en la coleccion");
            System.out.println("[4.] Mostrar todos los productos en la coleccion, ordenados por categoria");
            System.out.println("[5.] Mostrar todos los productos en inventario");
            System.out.println("[6.] Mostrar todos los productos en inventario ordenados por categoria");
            System.out.println("[7.] Salir\n");

            while (!flag){
                option = Integer.parseInt(input.nextLine());
                System.out.println();
                if (option > 0 && option <= 7)
                    flag = true;
                else{
                    System.out.println("ERROR");
                }
            }
        } catch (InputMismatchException e){
            String s = "ERROR" + option + ": " + e.toString();
            throw new InputMismatchException(s);
        } catch (Exception e){
            String s = "ERROR" +  option + ": " + e.toString();
            throw new Exception(s);
        }
        return option;
    }


    /**
     * Lectura de las propiedades de un producto nuevo
     * @return el producto nuevo
     */
    public String[] newProduct(){
        String[] product = new String[2];
        System.out.println("Ingrese el nombre del producto");
        String name = input.nextLine();
        System.out.println("Ingrese la categoria del producto");
        String category = input.nextLine();
        product[0] = name; product[1] = category;
        System.out.println();
        return product;
    }


    /**
     * Busqueda de producto
     * @return el producto que se busca
     */
    public String searchProduct(){
        String product = "";
        System.out.println("Ingrese el nombre del producto que desea buscar: \n");
        product = input.nextLine();
        return product;
    }

    /**
     * Imprime un texto en pantalla
     * @param text el mensaje a imprimir
     */
    public void output(String text){
        System.out.println(text);
    }


    /**
     * Mensaje de salida
     */
    public void exit(){
        System.out.println("Ha salido del programa");
    }
}
