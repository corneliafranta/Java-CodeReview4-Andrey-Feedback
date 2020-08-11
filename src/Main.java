import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Shop theShop = new Shop("M&M", "Brunnerstrasse 12");

        User user1 = new User("Jack", "Longarm", "jacklongarm@yahoo.com", "11th avenue 12, Washington", 31456, "+1 434 372863229");
        User user2 = new User("Rockie", "Balboa", "rockie@hotmail.com", "3rd Street, Amazons Rainforest", 3236, "+1 256 4869167991");
        User user3 = new User("Sam", "Schwarzwald", "samtheman@gmail.com", "Jeffersons Bullevar, 131, Washington", 31201, "+1 452 4869347242");
        User user4 = new User("Klaus", "Kraftsman", "klausthemaus@gmail.com", "Victor Adler strasse 7, Berlin", 12554, "+44 6654 97747784");

        HashMap<Integer, Product> products = theShop.getProducts();
        HashMap<Integer, User> users = theShop.getUsers();
        users.put(user1.getUserId(), user1);
        users.put(user2.getUserId(), user2);
        users.put(user3.getUserId(), user3);
        users.put(user4.getUserId(), user4);

        theShop.addProduct("blue t-shirts", "blue t-shirts with V shaped neck and long sleeves", 33, 8, Product.Category.T_SHIRTS);
        theShop.addProduct("red nike shirts", "red nike shirts for kids size 120-150", 31, 6, Product.Category.T_SHIRTS);
        theShop.addProduct("big circle earrings", "silver earrings for special occasion", 49, 7, Product.Category.ACCESSOIRES);
        theShop.addProduct("Angelo Litricio Jacket", "waterproof winter jacket for hiking and wandering", 99, 15, Product.Category.JACKETS);

        theShop.buyProduct(user1, products.get(1));
        theShop.buyProduct(user1, products.get(2));
        theShop.buyProduct(user1, products.get(3));
        theShop.buyProduct(user1, products.get(1));
        theShop.buyProduct(user1, products.get(2));
        theShop.buyProduct(user1, products.get(3));
        theShop.buyProduct(user1, products.get(3));
        theShop.buyProduct(user1, products.get(2));
        theShop.buyProduct(user2, products.get(2));
        theShop.buyProduct(user3, products.get(2));
        theShop.buyProduct(user4, products.get(2));
        theShop.buyProduct(user4, products.get(2));

        user1.printReport();
        user2.printReport();

        products.get(4).refillProduct(products.get(4));

            Menu theMenu = new Menu(products, users);

    }
}
