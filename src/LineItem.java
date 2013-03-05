/**
 * This class use the product quantity, the product methods and the FakeDatabase class to get the information 
 * information using the product ID as the key to the FakeDatabase
 * 
 * @author Jim Birchfield
 */
 

public class LineItem {
    private int prodQty;
    private Product product;
    private FakeDatabase db;
    
    public LineItem(String prID, int qty) {
        db = new FakeDatabase();
        product = db.findProduct(prID);
        prodQty = qty;
    }

    public int getProdQty() {
        return prodQty;
    }

    public void setProdQty(int prodQty) {
        this.prodQty = prodQty;
    }
    
    public double getExtendedPrice(){
        return product.getUnitCost() * prodQty;
    }  
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
    public String getProductID(){
        return product.getProductID();
    }
    
    public String getProductName(){
        return product.getProductName();
    }
    
        
    public double getDiscount(){
        return product.getDiscountAmt(prodQty);
    }
}
