/*
 * 
 */
public class LineItem {
    private String prodID;
    private String prodName;
    private int prodQty;
    private double unitCost;
    private Product product;

    public LineItem() {
        
    }
    
    public LineItem(String prID, String prName, int qty, double cost) {
        prodID = prID;
        prodName = prName;
        prodQty = qty;
        unitCost = cost;
    }

    public String getProdID() {
        return prodID;
    }

    public void setProdID(String prodID) {
        this.prodID = prodID;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdQty() {
        return prodQty;
    }

    public void setProdQty(int prodQty) {
        this.prodQty = prodQty;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }
    
    
}
