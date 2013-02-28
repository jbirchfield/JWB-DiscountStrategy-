/*
 * 
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
    
    
    public String getProductID(){
        return product.getProductID();
    }
    
    public String getProductName(){
        return product.getProductName();
    }
    
    public double getDiscount(){
        return product.getDiscountAmt(prodQty);
    }
    public static void main(String[] args) {
        // Expect .15 discount because qty >= 5
        LineItem lineItem = new LineItem("A101",6);
        System.out.println("Prod ID: " + lineItem.product.getProductID() );
        System.out.println("Product: " + lineItem.product.getProductName());
        System.out.println("Unit Cost: " + lineItem.product.getUnitCost());
        System.out.println("Quantity: " + lineItem.prodQty);
        System.out.println("Extended Price: " + lineItem.getExtendedPrice());
        System.out.println("Discount: " + lineItem.getDiscount());
        
        

    }
}
