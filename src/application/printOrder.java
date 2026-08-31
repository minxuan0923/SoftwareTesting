package application;

public class printOrder {
    private customer customerDetails;
    private String printType;          // "Black & White" or "Colour"
    private String paperSize;          // "A3", "A4", or "A5"
    private String printingSide;       // "Single-sided" or "Double-sided"
    private int numberOfPages;
    private int numberOfCopies;
    private String bindingOption;      // "None", "Staple Binding", "Comb Binding", "Spiral Binding"
    private boolean laminationOption;
    private boolean expressPrintingOption;

    private double basePrintingCharge;
    private double additionalServiceCharges;
    private double discounts;
    private double totalPrintingCharge;
    private String orderStatus;        // e.g., "Pending", "Completed", "Pending Payment"
    private String paymentStatus;      // e.g., "Unpaid", "Paid"

    public printOrder(customer customerDetails, String printType, String paperSize, String printingSide,
                      int numberOfPages, int numberOfCopies, String bindingOption,
                      boolean laminationOption, boolean expressPrintingOption) {
        setCustomer(customerDetails);
        setPrintType(printType);
        setPaperSize(paperSize);
        setPrintingSide(printingSide);
        setNumberOfPages(numberOfPages);
        setNumberOfCopies(numberOfCopies);
        setBindingOption(bindingOption);
        setLaminationOption(laminationOption);
        setExpressPrintingOption(expressPrintingOption);
        this.orderStatus = "Pending";
        this.paymentStatus = "Unpaid";
    }

    // Getters and Setters
    public customer getCustomer() { return customerDetails; }
    public void setCustomer(customer customerDetails) { 
    	if(customerDetails==null) {
    		throw new IllegalArgumentException();
    	}
    	this.customerDetails = customerDetails; 
    }
 
    public String getPrintType() { return printType; }
 
    // Must be one of the supported print types (Table 2)
    public void setPrintType(String printType) {
        if (!"Black & White".equals(printType) && !"Colour".equals(printType)) {
            throw new IllegalArgumentException("Print type must be 'Black & White' or 'Colour'.");
        }
        this.printType = printType;
    }
 
    public String getPaperSize() { return paperSize; }
 
    // Must be one of the supported paper sizes (Table 2)
    public void setPaperSize(String paperSize) {
        if (!"A3".equals(paperSize) && !"A4".equals(paperSize) && !"A5".equals(paperSize)) {
            throw new IllegalArgumentException("Paper size must be 'A3', 'A4', or 'A5'.");
        }
        this.paperSize = paperSize;
    }
 
    public String getPrintingSide() { return printingSide; }
 
    // Must be one of the supported printing sides (Table 2)
    public void setPrintingSide(String printingSide) {
        if (!"Single-sided".equals(printingSide) && !"Double-sided".equals(printingSide)) {
            throw new IllegalArgumentException("Printing side must be 'Single-sided' or 'Double-sided'.");
        }
        this.printingSide = printingSide;
    }
 
    public int getNumberOfPages() { return numberOfPages; }
 
    // Rules 6 & 7: at least 1 page, maximum 500 pages
    public void setNumberOfPages(int numberOfPages) {
        if (numberOfPages < 1 || numberOfPages > 500) {
            throw new IllegalArgumentException("Pages must be between 1 and 500.");
        }
        this.numberOfPages = numberOfPages;
    }
 
    public int getNumberOfCopies() { return numberOfCopies; }
 
    // Rules 6 & 8: at least 1 copy, maximum 1000 copies
    public void setNumberOfCopies(int numberOfCopies) {
        if (numberOfCopies < 1 || numberOfCopies > 1000) {
            throw new IllegalArgumentException("Copies must be between 1 and 1000.");
        }
        this.numberOfCopies = numberOfCopies;
    }
 
    public String getBindingOption() { return bindingOption; }
 
    // Rule 9: only one (valid) binding option may be selected
    public void setBindingOption(String bindingOption) {
        if (!"None".equals(bindingOption) && !"Staple Binding".equals(bindingOption)
                && !"Comb Binding".equals(bindingOption) && !"Spiral Binding".equals(bindingOption)) {
            throw new IllegalArgumentException(
                    "Binding option must be 'None', 'Staple Binding', 'Comb Binding', or 'Spiral Binding'.");
        }
        this.bindingOption = bindingOption;
    }
 
    public boolean isLaminationOption() { return laminationOption; }
    public void setLaminationOption(boolean laminationOption) {this.laminationOption = laminationOption; }
 
    public boolean isExpressPrintingOption() { return expressPrintingOption; }
    public void setExpressPrintingOption(boolean expressPrintingOption) { this.expressPrintingOption = expressPrintingOption; }
 
    public double getBasePrintingCharge() { return basePrintingCharge; }
    public void setBasePrintingCharge(double basePrintingCharge) { 
    	if (basePrintingCharge<=0) {
            throw new IllegalArgumentException("Base Printing Charge must be more than 0.");
        }
    	this.basePrintingCharge = basePrintingCharge; 
    	}
 
    public double getAdditionalServiceCharges() { return additionalServiceCharges; }
    public void setAdditionalServiceCharges(double additionalServiceCharges) { 
    	if (additionalServiceCharges<0) {
            throw new IllegalArgumentException("Additional Service Charges cannot be negative.");
        }
    	this.additionalServiceCharges = additionalServiceCharges; 
    	}
 
    public double getDiscounts() { return discounts; }
    public void setDiscounts(double discounts) { 
    	if (discounts<0) {
            throw new IllegalArgumentException("Discounts cannot be negative.");
        }
    	this.discounts = discounts; 
    	}
 
    public double getTotalPrintingCharge() { return totalPrintingCharge; }
    public void setTotalPrintingCharge(double totalPrintingCharge) { 
    	if (totalPrintingCharge <=0) {
            throw new IllegalArgumentException("Total Printing Charge must be larger than 0.");
        }
    	this.totalPrintingCharge = totalPrintingCharge; 
    	}
 
    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { 
    	if (!"Pending".equals(orderStatus) && !"Completed".equals(orderStatus)&& !"Pending Payment".equals(orderStatus)) {
            throw new IllegalArgumentException("Order status must be 'Pending', 'Completed' or 'Pending Payment'.");
        }
    	this.orderStatus = orderStatus; 
    }
 
    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { 
    	if (!"Unpaid".equals(paymentStatus) && !"Paid".equals(paymentStatus)) {
            throw new IllegalArgumentException("Payment Status must be 'Unpaid' or 'Paid'.");
        }
    	this.paymentStatus = paymentStatus; }
}