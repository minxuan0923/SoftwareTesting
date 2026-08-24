package application;

public class calculatePrintingCharge {
    private printerAvailability printerService;
    private applyDiscount discountService;

    public calculatePrintingCharge(printerAvailability printerService, applyDiscount discountService) {
        this.printerService = printerService;
        this.discountService = discountService;
    }

    public double calculate(printOrder order) {
        // 1. Check printer availability
        if (!printerService.isPrinterAvailable(order.getPaperSize(), order.getPrintType())) {
            System.out.println("Selected printer is currently unavailable.");
            return -1.0; // Terminate calculation with an error value
        }

        // 3. Base Printing Charge Calculation (Table 2)
        double rate = getBaseRate(order.getPaperSize(), order.getPrintType(), order.getPrintingSide());
        double baseCharge = rate * order.getNumberOfPages() * order.getNumberOfCopies();
        order.setBasePrintingCharge(baseCharge);

        // 4. Optional Service Charges Calculation (Table 3)
        double optionalCharges = 0.0;
        String binding = order.getBindingOption();
        if ("Staple Binding".equalsIgnoreCase(binding)) {
            optionalCharges += 2.00;
        } else if ("Comb Binding".equalsIgnoreCase(binding)) {
            optionalCharges += 5.00;
        } else if ("Spiral Binding".equalsIgnoreCase(binding)) {
            optionalCharges += 8.00;
        }

        if (order.isLaminationOption()) {
            // Business Rule 10: Lamination based on total pages (Pages * Copies)
            optionalCharges += 1.50 * order.getNumberOfPages() * order.getNumberOfCopies();
        }

        if (order.isExpressPrintingOption()) {
            optionalCharges += 20.00;
        }
        order.setAdditionalServiceCharges(optionalCharges);

        double subtotal = baseCharge + optionalCharges;

        // 5. Discount Calculations (Table 4)
        double discountAmount = discountService.calculateDiscount(order.getCustomer(), subtotal);
        order.setDiscounts(discountAmount);

        // 6. Rounding the total charge to 2 decimal places
        double total = subtotal - discountAmount;
        if (total < 0) total = 0;
        total = Math.round(total * 100.0) / 100.0;
        order.setTotalPrintingCharge(total);

        return total;
    }

    private double getBaseRate(String paperSize, String printType, String printingSide) {
        boolean singleSided = "Single-sided".equals(printingSide);
 
        if ("A4".equals(paperSize)) {
            if ("Black & White".equals(printType)) {
                return singleSided ? 0.20 : 0.18;
            } else {
                return singleSided ? 0.80 : 0.75;
            }
        } else if ("A3".equals(paperSize)) {
            if ("Black & White".equals(printType)) {
                return singleSided ? 0.40 : 0.35;
            } else {
                return singleSided ? 1.50 : 1.40;
            }
        } else {
            // paperSize == "A5"
            if ("Black & White".equals(printType)) {
                return singleSided ? 0.15 : 0.13;
            } else {
                return singleSided ? 0.60 : 0.55;
            }
        }
    }
}
