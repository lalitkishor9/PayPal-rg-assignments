public class textUtil {
    //    double rate = 0.15;
//
//    public double calculateTax(double amount) {
//        return amount * rate;
//    }
//    --No, it's not pure because it depends on an instance variable rate.
    public class TaxUtil {
        public double calculateTax(double amount, double rate) {
            return amount * rate;
        }
    }
//  --Now calculateTax() always returns the same result for the same inputs and has no side effects.
}

