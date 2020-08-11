import java.util.HashMap;

public class Shop {
    private String name;
    private String address;
    private HashMap<Integer, Product> products = new HashMap<>();
    private HashMap<Integer, User> users = new HashMap<>();

    public Shop(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public HashMap<Integer, Product> getProducts() {
        return products;
    }

    public void setProducts(Product product) {
        this.products.put(product.getProductId(), product);
    }

    public HashMap<Integer, User> getUsers() {
        return users;
    }

    public void setUsers(User user) {
        this.users.put(user.getUserId(), user);
    }

    public void addProduct(String name, String description, double price, int stock, Product.Category category){
        Product product = new Product(name, description, price, stock, category);
        this.setProducts(product);
        System.out.println("Successfully added product to shop");
        System.out.println(product.toString());
    }

    public void buyProduct(User user, Product product){
        // You could probably just call product.getStock() directly instead
        if(products.get(product.getProductId()).getStock()==0){
            System.out.println("sorry you cant buy this item, its out of stock");
            return;
        } else{
            user.addProductsBought(product);
            product.setStock(product.getStock()-1);
            System.out.println("Product purchased successfully");
        }
        if(product.getStock() == 4){
            System.out.println("ATTENTION: The stock of the item with ID: " + product.getProductId() + " is: " + product.getStock());
        }
    }
}
