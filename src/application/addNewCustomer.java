package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class addNewCustomer {

    private  BufferedWriter writer;

    public addNewCustomer() {
        try {
            writer = new BufferedWriter(new FileWriter("customer.txt", true));
        } catch (IOException e) {
            System.err.println("Error opening customer.txt for writing: " + e.getMessage());
        }
    }

    public addNewCustomer(BufferedWriter writer) {
        this.writer = writer;
    }

    public void addCustomer(customer cust) {
        if (cust == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }
        
        try {
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