package application;

public class applyDiscount {
    public double calculateDiscount(customer cust, double subtotal) {
    	if(cust==null) {
    		throw new IllegalArgumentException("Customer type cannot be null.");
    	}
    	if(subtotal<=0) {
    		throw new IllegalArgumentException("Subtotal cannot be smaller or equal to 0.");
    	}
        // Note: I think this validation is redundant since the customer class already validates previousOrders in its constructor and setter.
    	// if(cust.getPreviousOrders()<0) {
    	// 	throw new IllegalArgumentException("Previous orders cannot be negative.");
    	// }
    	
        double discountAmount = 0.0;
        double currentSubtotal = subtotal;

        // 1. Customer type discount (Student 10%, Corporate 15%)
        String type = cust.getCustomerType();
        if ("Student".equalsIgnoreCase(type)) {
            double d = currentSubtotal * 0.10;
            discountAmount += d;
            currentSubtotal -= d;
        } else if ("Corporate Customer".equalsIgnoreCase(type)) {
            double d = currentSubtotal * 0.15;
            discountAmount += d;
            currentSubtotal -= d;
        }

        // 2. Order subtotal exceeds RM300 (Additional 5%)
        if (subtotal > 300.0) {
            double d = currentSubtotal * 0.05;
            discountAmount += d;
            currentSubtotal -= d;
        }

        // 3. Existing customer with more than 20 previous orders (Additional 5%)
        if (cust.getPreviousOrders() > 20) {
            double d = currentSubtotal * 0.05;
            discountAmount += d;
            currentSubtotal -= d;
        }

        return discountAmount;
    }
}
