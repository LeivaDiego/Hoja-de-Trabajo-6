public class Main {
    public static void main(String[] args) {
        View view = new View();
        try {
            view.welcome();
            int mapOption = view.mapOption();
            Manager onlineStore = new Manager(mapOption);
            int option = -1;
            while(option != 7){
                String result = "";
                option = view.menu();
                switch (option){
                    case 1:
                        String[] product = view.newProduct();
                        result = onlineStore.newProduct(product[1], product[0]);
                        view.output(result);
                        break;
                    case 2:
                        String nameProduct = view.searchProduct();
                        result = onlineStore.searchCategory(nameProduct);
                        view.output(result);
                        break;
                    case 3:
                        result = onlineStore.showProducts(option,mapOption);
                        view.output(result);
                        break;
                    case 4:
                        result = onlineStore.showProducts(option,mapOption);
                        view.output(result);
                        break;
                    case 5:
                        result = onlineStore.showProducts(option,mapOption);
                        view.output(result);
                        break;
                    case 6:
                        result = onlineStore.showProducts(option,mapOption);
                        view.output(result);
                        break;
                }
            }
            view.exit();
        } catch (Exception e) {
            String s = "ERROR: " + e.getMessage();
            view.error(s);
        }
    }
}