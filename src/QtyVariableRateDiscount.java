
public class QtyVariableRateDiscount implements DiscountStrategy{
    private double discountRate;
    private int minQty;
            
    
    
    public QtyVariableRateDiscount(double rate, int qty) {
        discountRate = rate;
        minQty = qty;
    } 
    public double getDiscountAmt(int qty, double unitCost) {
        if (qty >= minQty)
            {return unitCost * qty * discountRate;}
        else
            return 0;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }    
        
    public static void main(String[] args) {
        VariableRateDiscount app2 = new VariableRateDiscount(.10);
        double amt = app2.getDiscountAmt(2, 20);
        System.out.println("Discount amt: " + amt);
    }
    
}
