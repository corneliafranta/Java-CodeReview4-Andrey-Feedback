public class Product {
    private static int productIdIncrementor = 1;
    private int productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int stock;
    enum Category {
        T_SHIRTS,
        TROUSERS,
        SHIRTS,
        JACKETS,
        ACCESSOIRES
    }
    private Category category;

    public Product(String productName, String productDescription, double productPrice, int stock, Category category) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.stock = stock;
        productId = productIdIncrementor++;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // This function doesn't do what its name suggests, it only checks if the stock exceeds the limit of 14 items.
    // I guess it was meant to also call setStock?
    public void refillProduct(Product product){
        System.out.println("*** REFILLING PRODUCT ***");

        int productID = product.getProductId();
        // This is absolutely fine because you only use it here but you might also want to move the value (14)
        // to a class attribute, for readability and reusability. Sometimes when you work on very big projects
        // crawling through all these parameters can be tedious and it saves a lot of time and energy
        // to either place them in a configuration file/class or as class attributes/defaults.
        if(product.getStock()>14){

            try {
                // You could move your System.out.println() directly to StockLimitReachedException and
                // remove the need for this try / catch block.
                throw new StockLimitReachedException("The product has max units in the stock, you cannot add more");
            }
            catch (Exception ex){
                System.out.println(ex);
                return;
            }
        }
    }

    @Override
    public String toString() {
        return
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", stock=" + stock +
                ", category=" + category;
    }



}
