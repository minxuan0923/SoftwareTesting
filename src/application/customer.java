package application;

import java.util.regex.Pattern;

public class customer {
	
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
	private static final Pattern PHONE_PATTERN = Pattern.compile("^01\\d{8,9}$");
    private String customerID;
    private String name;
    private String email;
    private String phone;
    private String customerType; // e.g., "Student", "Corporate Customer", "Regular"
    private int previousOrders;

    public customer() {}

    public customer(String customerID, String name, String email, String phone, String customerType, int previousOrders) {
        this.customerID = customerID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.customerType = customerType;
        this.previousOrders = previousOrders;
    }

    // Static helper to retrieve details from readCustomer
    public static customer retrieveCustomer(String id) {
        readCustomer reader = new readCustomer();
        return reader.getCustomerByID(id);
    }

    // Getters and Setters
    public String getCustomerID() { return customerID; }
    
    //validate customerID cannot be null or empty, and first character must be 'C' while others must be digits
    public void setCustomerID(String customerID) {
        if (customerID == null || customerID.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty.");
        }
        // first character must be 'C', followed digits,
        // and there must be at least one digit after the 'C'.
        String trimmedID = customerID.trim();
        if (trimmedID.length() < 2 || trimmedID.charAt(0) != 'C') {
            throw new IllegalArgumentException("Customer ID must start with 'C' followed by digits (e.g. C01).");
        }
        for (int i = 1; i < trimmedID.length(); i++) {
            if (!Character.isDigit(trimmedID.charAt(i))) {
                throw new IllegalArgumentException("Customer ID must start with 'C' followed by digits (e.g. C01).");
            }
        }
        this.customerID = customerID;
    }

    public String getName() { return name; }
    
    //validate name cannot be null and must be 2-50 characters
    public void setName(String name) {
        if (name == null||name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        int length = name.trim().length();
        if (length < 2 || length > 50) {
            throw new IllegalArgumentException("Name must be between 2 and 50 characters.");
        }
        this.name = name;
    }

    public String getEmail() { return email; }
    
    public void setEmail(String email) {
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Email format is invalid.");
        }
        this.email = email;
    }
        
        
    public String getPhone() { return phone; }
    
    /**
     * Only accepts phone numbers starting with "01" that contain
     * 10 or 11 digits in total (e.g. 012-3456789, 011-12345678).
     * Dashes and other non-digit characters are stripped before storing.
     */
    public void setPhone(String phone) {
        if (phone == null||phone.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }
        String digitsOnly = phone.replaceAll("[^0-9]", "");
 
        if (!PHONE_PATTERN.matcher(digitsOnly).matches()) {
            throw new IllegalArgumentException(
                    "Phone number must start with 01 and contain 10 or 11 digits.");
        }
        this.phone = digitsOnly;
    }
    public String getCustomerType() { return customerType; }
    
    //validate customerType
    public void setCustomerType(String customerType) {
        if (customerType == null||customerType.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer type cannot be null.");
        }
        if (!customerType.equalsIgnoreCase("Regular")
                && !customerType.equalsIgnoreCase("Corporate Customer")
                && !customerType.equalsIgnoreCase("Student")) {
            throw new IllegalArgumentException(
                    "Customer type must be 'Regular', 'Corporate Customer', or 'Student'.");
        }
        this.customerType = customerType;
    }

    public int getPreviousOrders() { return previousOrders; }
    public void setPreviousOrders(int previousOrders) {
        if (previousOrders < 0) {
            throw new IllegalArgumentException("Previous orders cannot be negative.");
        }
        this.previousOrders = previousOrders;
    }
}