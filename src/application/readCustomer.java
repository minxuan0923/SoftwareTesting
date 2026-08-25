package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readCustomer {
    public customer getCustomerByID(String customerID) {
    	
    	if (customerID == null || customerID.trim().isEmpty()) {
    	    throw new IllegalArgumentException("Customer ID cannot be null or empty.");
    	}
    	
        try (BufferedReader reader = new BufferedReader(new FileReader("customer.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6 && parts[0].trim().equalsIgnoreCase(customerID.trim())) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String email = parts[2].trim();
                    String phone = parts[3].trim();
                    String type = parts[4].trim();
                    int prevOrders = Integer.parseInt(parts[5].trim());
                    return new customer(id, name, email, phone, type, prevOrders);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading customer.txt: " + e.getMessage());
        }
        return null; // Returns null if the customer is not found
    }
}