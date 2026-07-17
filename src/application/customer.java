package application;

public class customer {
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
    public void setCustomerID(String customerID) { this.customerID = customerID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getCustomerType() { return customerType; }
    public void setCustomerType(String customerType) { this.customerType = customerType; }

    public int getPreviousOrders() { return previousOrders; }
    public void setPreviousOrders(int previousOrders) { this.previousOrders = previousOrders; }
}