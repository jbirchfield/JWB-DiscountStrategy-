/**
 * This class implements the DiscountStrategy interface.  If the number of items purchased of
 * a product exceeds a minimum quantity level,a discount amount is calculated.  
 * 
 * @author Jim Birchfield
 */
public class QtyVariableRateDiscount implements DiscountStrategy{
    private double discountRate;
    private int minQty;
            
    
    
    public QtyVariableRateDiscount(double rate, int minimumQty) {
        discountRate = rate;
        minQty = minimumQty;
    } 
    public double getDiscountAmt(int qtyPurchased, double unitCost) {
        if (qtyPurchased >= minQty)
            {return unitCost * qtyPurchased * discountRate;}
        else
            return 0;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }    
        
//    public static void main(String[] args) {
//        VariableRateDiscount app2 = new VariableRateDiscount(.10);
//        double amt = app2.getDiscountAmt(2, 20);
//        System.out.println("Discount amt: " + amt);
//    }
    
}
