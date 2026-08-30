package application;

public class generateInvoice {
    public String generate(printOrder order) {
    	if(order==null) {
    		throw new IllegalArgumentException();
    	}
        customer cust = order.getCustomer();
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