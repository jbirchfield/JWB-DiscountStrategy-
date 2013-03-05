/**
 * This class implements the DiscountStrategy interface.  A discount amount is
 * calculated for any quantity of a purchased product.
 * 
 * @author Jim Birchfield
 */
 
public class VariableRateDiscount implements DiscountStrategy{
    private double discountRate;
    
    public VariableRateDiscount(double rate) {
        discountRate = rate;
    } 
    public double getDiscountAmt(int qty, double unitCost) {
        return unitCost * qty * discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }    
        
//    public static void main(String[] args) {
//        VariableRateDiscount app1 = new VariableRateDiscount(.10);
//        double amt = app1.getDiscountAmt(2, 20);
//        System.out.println("Discount amt: " + amt);
//    }
    
}
