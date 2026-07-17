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

    public printOrder() {}

    public printOrder(customer customerDetails, String printType, String paperSize, String printingSide,
                      int numberOfPages, int numberOfCopies, String bindingOption,
                      boolean laminationOption, boolean expressPrintingOption) {
        this.customerDetails = customerDetails;
        this.printType = printType;
        this.paperSize = paperSize;
        this.printingSide = printingSide;
        this.numberOfPages = numberOfPages;
        this.numberOfCopies = numberOfCopies;
        this.bindingOption = bindingOption;
        this.laminationOption = laminationOption;
        this.expressPrintingOption = expressPrintingOption;
        this.orderStatus = "Pending";
        this.paymentStatus = "Unpaid";
    }

    // Getters and Setters
    public customer getCustomer() { return customerDetails; }
    public void setCustomer(customer customerDetails) { this.customerDetails = customerDetails; }

    public String getPrintType() { return printType; }
    public void setPrintType(String printType) { this.printType = printType; }

    public String getPaperSize() { return paperSize; }
    public void setPaperSize(String paperSize) { this.paperSize = paperSize; }

    public String getPrintingSide() { return printingSide; }
    public void setPrintingSide(String printingSide) { this.printingSide = printingSide; }

    public int getNumberOfPages() { return numberOfPages; }
    public void setNumberOfPages(int numberOfPages) { this.numberOfPages = numberOfPages; }

    public int getNumberOfCopies() { return numberOfCopies; }
    public void setNumberOfCopies(int numberOfCopies) { this.numberOfCopies = numberOfCopies; }

    public String getBindingOption() { return bindingOption; }
    public void setBindingOption(String bindingOption) { this.bindingOption = bindingOption; }

    public boolean isLaminationOption() { return laminationOption; }
    public void setLaminationOption(boolean laminationOption) { this.laminationOption = laminationOption; }

    public boolean isExpressPrintingOption() { return expressPrintingOption; }
    public void setExpressPrintingOption(boolean expressPrintingOption) { this.expressPrintingOption = expressPrintingOption; }

    public double getBasePrintingCharge() { return basePrintingCharge; }
    public void setBasePrintingCharge(double basePrintingCharge) { this.basePrintingCharge = basePrintingCharge; }

    public double getAdditionalServiceCharges() { return additionalServiceCharges; }
    public void setAdditionalServiceCharges(double additionalServiceCharges) { this.additionalServiceCharges = additionalServiceCharges; }

    public double getDiscounts() { return discounts; }
    public void setDiscounts(double discounts) { this.discounts = discounts; }

    public double getTotalPrintingCharge() { return totalPrintingCharge; }
    public void setTotalPrintingCharge(double totalPrintingCharge) { this.totalPrintingCharge = totalPrintingCharge; }

    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
}