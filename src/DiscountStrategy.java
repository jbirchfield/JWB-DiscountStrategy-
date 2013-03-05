/**
 * This class contains the interface used to calculate discounts.  Its abstract methods
 * are implemented in the classes that implement this interface.  It serves as an
 * abstraction layer.
 * 
 * @author Jim Birchfield
 */


public interface DiscountStrategy {

    public abstract double getDiscountAmt(int qty, double unitCost);
    
    public abstract double getDiscountRate();
    
    public abstract void setDiscountRate(double discountRate);
    
    
}
