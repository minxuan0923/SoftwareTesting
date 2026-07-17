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

        // 2. Business Rules Validation (at least 1 page & 1 copy, max 500 pages, max 1000 copies)
        if (order.getNumberOfPages() < 1 || order.getNumberOfPages() > 500) {
            throw new IllegalArgumentException("Pages must be between 1 and 500.");
        }
        if (order.getNumberOfCopies() < 1 || order.getNumberOfCopies() > 1000) {
            throw new IllegalArgumentException("Copies must be between 1 and 1000.");
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
        if ("A4".equalsIgnoreCase(paperSize)) {
            if ("Black & White".equalsIgnoreCase(printType)) {
                return "Single-sided".equalsIgnoreCase(printingSide) ? 0.20 : 0.18;
            } else if ("Colour".equalsIgnoreCase(printType)) {
                return "Single-sided".equalsIgnoreCase(printingSide) ? 0.80 : 0.75;
            }
        } else if ("A3".equalsIgnoreCase(paperSize)) {
            if ("Black & White".equalsIgnoreCase(printType)) {
                return "Single-sided".equalsIgnoreCase(printingSide) ? 0.40 : 0.35;
            } else if ("Colour".equalsIgnoreCase(printType)) {
                return "Single-sided".equalsIgnoreCase(printingSide) ? 1.50 : 1.40;
            }
        } else if ("A5".equalsIgnoreCase(paperSize)) {
            if ("Black & White".equalsIgnoreCase(printType)) {
                return "Single-sided".equalsIgnoreCase(printingSide) ? 0.15 : 0.13;
            } else if ("Colour".equalsIgnoreCase(printType)) {
                return "Single-sided".equalsIgnoreCase(printingSide) ? 0.60 : 0.55;
            }
        }
        throw new IllegalArgumentException("Invalid combination of paper size, print type, or printing side");
    }
}