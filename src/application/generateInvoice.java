package application;

public class generateInvoice {
    public String generate(printOrder order) {
        if (order == null) {
            throw new IllegalArgumentException("Invalid print order: order cannot be null.");
        }
        customer cust = order.getCustomer();

        if (cust == null) {
            throw new IllegalArgumentException("Invalid print order: customer cannot be null.");
        } else if (cust.getCustomerID() == null) {
            throw new IllegalArgumentException("Invalid print order: customer ID cannot be null.");
        } else if (cust.getName() == null) {
            throw new IllegalArgumentException("Invalid print order: customer name cannot be null.");
        } else if (cust.getEmail() == null) {
            throw new IllegalArgumentException("Invalid print order: customer email cannot be null.");
        } else if (cust.getPhone() == null) {
            throw new IllegalArgumentException("Invalid print order: customer phone cannot be null.");
        } else if (cust.getCustomerType() == null) {
            throw new IllegalArgumentException("Invalid print order: customer type cannot be null.");
        } else if (order.getOrderStatus() == null) {
            throw new IllegalArgumentException("Invalid print order: order status cannot be null.");
        } else if (order.getPaperSize() == null) {
            throw new IllegalArgumentException("Invalid print order: paper size cannot be null.");
        } else if (order.getPrintType() == null) {
            throw new IllegalArgumentException("Invalid print order: print type cannot be null.");
        } else if (order.getPaymentStatus() == null) {
            throw new IllegalArgumentException("Invalid print order: payment status cannot be null.");
        } else if (order.getPrintingSide() == null) {
            throw new IllegalArgumentException("Invalid print order: printing side cannot be null.");
        } else if (order.getBindingOption() == null) {
            throw new IllegalArgumentException("Invalid print order: binding option cannot be null.");
        }

        StringBuilder sb = new StringBuilder();
        sb.append("=================== INVOICE ===================\n");
        sb.append("Customer ID: ").append(cust.getCustomerID()).append("\n");
        sb.append("Customer Name: ").append(cust.getName()).append("\n");
        sb.append("Email: ").append(cust.getEmail()).append("\n");
        sb.append("Phone: ").append(cust.getPhone()).append("\n");
        sb.append("Type: ").append(cust.getCustomerType()).append("\n");
        sb.append("-----------------------------------------------\n");
        sb.append("Paper Size: ").append(order.getPaperSize()).append("\n");
        sb.append("Print Type: ").append(order.getPrintType()).append("\n");
        sb.append("Side: ").append(order.getPrintingSide()).append("\n");
        sb.append("Pages: ").append(order.getNumberOfPages()).append("\n");
        sb.append("Copies: ").append(order.getNumberOfCopies()).append("\n");
        sb.append("Binding: ").append(order.getBindingOption()).append("\n");
        sb.append("Lamination: ").append(order.isLaminationOption() ? "Yes" : "No").append("\n");
        sb.append("Express: ").append(order.isExpressPrintingOption() ? "Yes" : "No").append("\n");
        sb.append("-----------------------------------------------\n");
        sb.append(String.format("Base Printing Charge: RM%.2f\n", order.getBasePrintingCharge()));
        sb.append(String.format("Optional Service Charges: RM%.2f\n", order.getAdditionalServiceCharges()));
        sb.append(String.format("Discounts Applied: RM%.2f\n", order.getDiscounts()));
        sb.append(String.format("Total Amount Payable: RM%.2f\n", order.getTotalPrintingCharge()));
        sb.append("===============================================");

        String invoiceOutput = sb.toString();
        System.out.println(invoiceOutput);
        return invoiceOutput;
    }
}