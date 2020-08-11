import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class User {
    private static int userIdIncrementor = 1;
    private int userId;
    private String firstName;
    private String lastName;
    private String eMail;
    private String address;
    private int zipCode;
    private String phone;
    ArrayList<Product> productsBought = new ArrayList<>();

    public User(String firstName, String lastName, String eMail, String address, int zipCode, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.address = address;
        this.zipCode = zipCode;
        this.phone = phone;
        userId = userIdIncrementor++;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Product> getProductsBought() {
        return productsBought;
    }

    public void addProductsBought(Product productsBought) {
        this.productsBought.add(productsBought);
    }

    public void printReport(){
        String filename = "ReportUser" + this.getUserId() + ".txt";

        try{
            File file1 = new File(filename);
            file1.createNewFile();
            FileWriter writer = new FileWriter(filename);
            writer.write("Purchase history for UserID: " + this.getUserId() + " name: " + this.getFirstName() + "  surname: " + this.getLastName() + "\n\n");
            for(Product i : this.productsBought){
                writer.write(i.toString());
                writer.write("\n");
            }
            writer.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }

    @Override
    public String toString() {
        return
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", address='" + address + '\'' +
                ", zipCode=" + zipCode +
                ", phone='" + phone + '\''
                ;
    }
}
