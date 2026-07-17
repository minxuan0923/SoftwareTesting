package application;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class addNewCustomer {
    public void addCustomer(customer cust) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("customer.txt", true))) {
            writer.write(cust.getCustomerID() + "," +
                         cust.getName() + "," +
                         cust.getEmail() + "," +
                         cust.getPhone() + "," +
                         cust.getCustomerType() + "," +
                         cust.getPreviousOrders());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to customer.txt: " + e.getMessage());
        }
    }
}