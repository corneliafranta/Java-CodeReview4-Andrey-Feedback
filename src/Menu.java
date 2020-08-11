import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    public Menu(HashMap<Integer, Product> products, HashMap<Integer, User> users) {
        String lineSeparator = "-".repeat(20);
        int totalSpaces = 22;
        String firstLine = "Welcome";
        String secondLine = "to the";
        String thirdLine = "Shop";

        System.out.println("+" + lineSeparator + "+");
        // Maybe formatting the lines like this makes it easier to read. In your IDE there is an indicator called
        // soft wrap which "dictates" how many characters a line can have. You should see it by default to the right ->
        // it's a grey line that is vertical. In theory, it's best to not go above this line as it reduces
        // code readability and people who are skilled with linux editors or for example git tend to do a lot of work
        // using the terminal in editors like vim/nano and there line width really does matter as they have no easy
        // to horizontally scroll in their UI.
        System.out.println(centerFormating(firstLine, totalSpaces) + "\n" +
                centerFormating(secondLine, totalSpaces) + "\n" + centerFormating(thirdLine, totalSpaces));
        System.out.println("+" + lineSeparator + "+");

        final int DISPLAY_ALL_USERS = 1;
        final int ENTER_NEW_USER = 2;
        final int DELETE_USER = 3;
        final int DISPLAY_ALL_PRODUCTS = 4;
        final int DISPLAY_PRODUCTS_BY_CATEGORY = 5;
        final int DISPLAY_ALL_OUT_OF_STOCK_PRODUCTS = 6;
        final int ENTER_NEW_PRODUCT = 7;
        final int REFILL_PRODUCT = 8;
        final int CREATE_USER_REPORT = 9;
        final int EXIT = 0;

        String commandChoices = " 1) DISPLAY_ALL_USERS\n " +
                "2) ENTER_NEW_USER\n 3) DELETE_USER\n 4) DISPLAY_ALL_PRODUCTS\n 5) DISPLAY_PRODUCTS_BY_CATEGORY\n" +
                " 6) DISPLAY_ALL_OUT_OF_STOCK_PRODUCTS\n 7) ENTER_NEW_PRODUCT\n 8) REFILL_PRODUCT\n " +
                "9) CREATE_USER_REPORT\n 0) EXIT";



        boolean toContinue = true;

        final int T_SHIRTS = 1;
        final int TROUSERS = 2;
        final int SHIRTS = 3;
        final int JACKETS = 4;
        final int ACCESSOIRES = 5;
        String categoryCommands = " 1) T_SHIRTS\n 2) TROUSERS\n 3) SHIRTS\n 4) JACKETS\n 5) ACCESSOIRES";

        // Normally you would have way more than just 2 days to complete such a project and I think it looks great,
        // I guess that if you would have had more time you would have done this yourself; it might make sense
        // to move the code that you have in your case blocks to separate functions as your swtich statement
        // is really long -> For someone unfamilliar with your code or the project itself (I have some insight via
        // Cornelia) a long statement can be hard to read, or at least harder than it needs to be:
        //  not because it's bad, this happens to any code, no matter how good, when it starts growing in complexity.
        // There is a term for this, and a lot of software developers,
        // (myself included) no matter how many years of experience they have tend to do it:
        // https://en.wikipedia.org/wiki/Spaghetti_code
        // This comment is only valid if this program would be a program thats actually used by other people than you
        // or worked on, e.g. a commerical product. For personal projects where you know the architecture of your code
        // it really doesn't matter.
        while(toContinue){
            System.out.println("****** ENTER A COMMAND *******");
            System.out.println(commandChoices);
            Scanner scanner = new Scanner(System.in);
            int theCommandGiven = scanner.nextInt();
            switch (theCommandGiven){
                // Nice that you named your ints, this makes the code way easier to understand.
                case EXIT:
                    System.out.println("APPLICATION CLOSED");
                    toContinue = !toContinue;
                    break;
                case DISPLAY_ALL_USERS:
                    System.out.println("***PRINTING ALL THE USERS***");
                    for(int userID : users.keySet()){
                        System.out.println(users.get(userID).toString());
                    }
                    break;
                case ENTER_NEW_USER:
                    System.out.println("***CREATING NEW USER***\n");
                    System.out.println("Enter first name:\n>>");
                    scanner = new Scanner(System.in);
                    String firstName = scanner.nextLine();

                    System.out.println("Enter last name:\n>>");
                    scanner = new Scanner(System.in);
                    String lastName = scanner.nextLine();

                    System.out.println("Enter eMail:\n>>");
                    scanner = new Scanner(System.in);
                    String eMail = scanner.nextLine();

                    System.out.println("Enter Address:\n>>");
                    scanner = new Scanner(System.in);
                    String address = scanner.nextLine();

                    System.out.println("Enter zip code:\n>>");
                    scanner = new Scanner(System.in);
                    int zipCode = scanner.nextInt();

                    System.out.println("Enter phone:\n>>");
                    scanner = new Scanner(System.in);
                    String phone = scanner.nextLine();

                    User newUser = new User(firstName, lastName, eMail, address, zipCode, phone);
                    users.put(newUser.getUserId(), newUser);
                    System.out.println("Successfully created user: " + newUser.toString());
                    break;
                case DELETE_USER:
                    System.out.println("***DELETING USER***\n");
                    System.out.println("Please enter the ID of the user you want to delete");
                    scanner = new Scanner(System.in);
                    int userId = scanner.nextInt();
                    if(users.containsKey(userId)){
                        users.remove(userId);
                        System.out.println("User with ID: " + userId + "successfully removed");
                    } else {
                        System.out.println("Sorry, there is no user with that ID in our system");
                    }
                    break;

                case DISPLAY_ALL_PRODUCTS:
                    System.out.println("***DISPLAYING ALL PRODUCTS***\n");
                    for(int productID : products.keySet()){
                        System.out.println(products.get(productID).toString());
                    }
                    break;
                case DISPLAY_PRODUCTS_BY_CATEGORY:
                    System.out.println("***DISPLAYING PRODUCTS BY CATEGORY***\n");
                    System.out.println("Please choose a category");
                    System.out.println(categoryCommands);
                    scanner = new Scanner(System.in);
                    int commandEntered = scanner.nextInt();

                    switch (commandEntered){
                        case T_SHIRTS:
                            System.out.println("**Printing all T_SHIRTS");
                            for(int productID : products.keySet()){
                                if(products.get(productID).getCategory().equals(Product.Category.T_SHIRTS)) {
                                    System.out.println(products.get(productID).toString());
                                }
                            }
                            break;
                        case TROUSERS:
                            System.out.println("**Printing all TROUSERS");
                            for(int productID : products.keySet()){
                                if(products.get(productID).getCategory().equals(Product.Category.TROUSERS)) {
                                    System.out.println(products.get(productID).toString());
                                }
                            }
                            break;
                        case SHIRTS:
                            System.out.println("**Printing all SHIRTS");
                            for(int productID : products.keySet()){
                                if(products.get(productID).getCategory().equals(Product.Category.SHIRTS)) {
                                    System.out.println(products.get(productID).toString());
                                }
                            }
                            break;
                        case JACKETS:
                            System.out.println("**Printing all JACKETS");
                            for(int productID : products.keySet()){
                                if(products.get(productID).getCategory().equals(Product.Category.JACKETS)) {
                                    System.out.println(products.get(productID).toString());
                                }
                            }
                            break;
                        case ACCESSOIRES:
                            System.out.println("**Printing all ACCESSOIRES");
                            for(int productID : products.keySet()){
                                if(products.get(productID).getCategory().equals(Product.Category.ACCESSOIRES)) {
                                    System.out.println(products.get(productID).toString());
                                }
                            }
                            break;
                        default:
                            System.out.println("Sorry, category you selected doesnt exists");
                    }
                    break;
                case DISPLAY_ALL_OUT_OF_STOCK_PRODUCTS:
                    System.out.println("***DISPLAYING ALL PRODUCTS OUT OF STOCK***\n");
                    for(int productID : products.keySet()){
                        if(products.get(productID).getStock() == 0){
                            System.out.println(products.get(productID).toString());
                        }
                    }
                    break;
                case ENTER_NEW_PRODUCT:
                    System.out.println("*** CREATING NEW PRODUCT ***");

                    System.out.println("Enter products name:\n>>");
                    scanner = new Scanner(System.in);
                    String productName = scanner.nextLine();

                    System.out.println("Enter products Description:\n>>");
                    scanner = new Scanner(System.in);
                    String productDescription = scanner.nextLine();

                    System.out.println("Enter products price:\n>>");
                    scanner = new Scanner(System.in);
                    double price = scanner.nextDouble();

                    System.out.println("Enter products stock:\n>>");
                    scanner = new Scanner(System.in);
                    int stock = scanner.nextInt();
                    // In products this number is 14 -> See comment I left there about global variables or
                    // configuration classes / class attributes.
                    if(stock>15){
                        stock =15;
                        System.out.println("You cannot have more than 15 items in stock, only 15 will be added");
                    }

                    System.out.println("Select products category:\n>>");
                    System.out.println(categoryCommands);
                    scanner = new Scanner(System.in);
                    int selectedCategory = scanner.nextInt();
                    Product.Category categoryToAdd = null;

                    switch (selectedCategory){
                        case T_SHIRTS:
                            categoryToAdd = Product.Category.T_SHIRTS;
                            break;
                        case TROUSERS:
                            categoryToAdd = Product.Category.TROUSERS;
                            break;
                        case SHIRTS:
                            categoryToAdd = Product.Category.SHIRTS;
                            break;
                        case JACKETS:
                            categoryToAdd = Product.Category.JACKETS;
                            break;
                        case ACCESSOIRES:
                            categoryToAdd = Product.Category.ACCESSOIRES;
                            break;
                    }

                    Product productToAdd = new Product(productName, productDescription, price, stock, categoryToAdd);
                    products.put(productToAdd.getProductId(), productToAdd);
                    System.out.println("Successfully created new product");
                    break;
                case REFILL_PRODUCT:
                    System.out.println("*** REFILLING PRODUCT ***");
                    System.out.println("Please enter the ID of the product you want to refill");
                    scanner = new Scanner(System.in);
                    int productID = scanner.nextInt();
                    // You should probably just use Product.refillProduct and move the below logic into it.
                    if(products.get(productID).getStock()>14){
                        try {
                            throw new StockLimitReachedException("The product has max units in the stock, you cannot add more");
                        }
                        catch (Exception ex){
                            System.out.println(ex);
                            break;
                        }
                        }


                    System.out.println("Please enter how many units you will add");
                    scanner = new Scanner(System.in);
                    int unitsToAdd = scanner.nextInt();
                    int newStock = products.get(productID).getStock() + unitsToAdd;
                    if(newStock>15){
                        System.out.println("You try to add more units than the max allowed, stock will be filled to max");
                        products.get(productID).setStock(15);
                    } else{
                        products.get(productID).setStock(newStock);
                        System.out.println("New stock is: " + newStock + " units");
                    }
                    break;
                case CREATE_USER_REPORT:
                    System.out.println("*** CREATING REPORT FILE ***");
                    System.out.println("Please enter the ID of the user you want to create report for");
                    scanner = new Scanner(System.in);
                    userId = scanner.nextInt();
                    if(!users.containsKey(userId)){
                        System.out.println("You cannot generate report for an inexistent user");
                        break;
                    }
                    String filename = "ReportUser" + userId + ".txt";
                    try{
                        // You could consider create file reader/writer class and reuse it here and in your user class
                        // or it might be that this logic is the same and you meant to call your user.printReport()
                        // method
                        File file1 = new File(filename);
                        file1.createNewFile();
                        FileWriter writer = new FileWriter(filename);
                        writer.write("Purchase history for UserID: " + userId + " name: " + users.get(userId).getFirstName() + "  surname: " + users.get(userId).getLastName() + "\n\n");
                        for(Product i : users.get(userId).productsBought){
                            writer.write(i.toString());
                            writer.write("\n");
                        }
                        System.out.println("Successfully created report file: " + filename);
                        writer.close();
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                default:
                    System.out.println("Command not found please restart the programm");


            }
        }


    }
    private String centerFormating(String line, int totalSpaces){
        String theLine =  "|" + " ".repeat((totalSpaces-line.length())/2) + line;
        theLine += " ".repeat(totalSpaces-theLine.length() -1) + "|";
        return  theLine;
    }



}
