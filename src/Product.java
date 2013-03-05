/**
 * This class defines the product and provides the methods to get the product information
 * and determines which discount strategy to use
 * 
 * @author Jim Birchfield
 */
public class Product {
    
    private String productID;
    private String productName;
    private double unitCost;
    private DiscountStrategy discountStrategy;
    
    public Product(){
    }

    public Product(String productID, String productName, double unitCost, DiscountStrategy discountStrategy) {
        this.productID = productID;
        this.productName = productName;
        this.unitCost = unitCost;
        this.discountStrategy = discountStrategy;
    }
       
    public double getDiscountAmt(int qty) {
        return discountStrategy.getDiscountAmt(qty, unitCost);
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public DiscountStrategy getDiscount() {
        return discountStrategy;
    }

 //   public void setDiscount(VariableRateDiscount discount) {
 //       this.discountStrategy = discount;
 //   }
    
    public void setDiscount(QtyVariableRateDiscount discount) {
        this.discountStrategy = discount;
    }
    
 }
