
import java.text.*;
import java.util.*;

public class Receipt {
    
    private LineItem[] lineItems = new LineItem[0];
    private Customer customer;
    private FakeDatabase db;
    
    public Receipt() {
    }
    
     public Receipt(String cID) {
        db = new FakeDatabase();
        customer = db.findCustomer(cID); 
    }
     
     public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
     

    public void addProductToSale(String prodID, int prodQty){
        LineItem lineItem = new LineItem(prodID, prodQty);
        addToArray(lineItem);
    }
    
    private void addToArray(LineItem item) {
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }
    
    public String getCurrentDate() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        date = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
        return sdf.format(date);
    }                
              
    public double getTotalBeforeDiscount(){ 
        double beforeDiscountTotal = 0.0;
        for(LineItem item : lineItems) {
            beforeDiscountTotal += item.getExtendedPrice();
        }
        return beforeDiscountTotal;
    }
    
    public double getTotalDiscount() {
        double totalDiscount = 0.0;
        for(LineItem item : lineItems) {
            totalDiscount += item.getDiscount();
        }
        return totalDiscount;
    }
            
    public double getTotalAfterDiscount(){
        double afterDiscountTotal = 0.0;
        afterDiscountTotal = getTotalBeforeDiscount() - getTotalDiscount();
        return afterDiscountTotal;
    }
    
    DecimalFormat formatter = new DecimalFormat("#0.00");

    public void outputReceipt() {
        String s = "Thanks for Shopping With Us!\n\n";
        s += "Date of Receipt: " + getCurrentDate() + "\n\n";
        s += "Sold to: " + customer.getFullName()+ "\n\n";
        s += "ID\t" + "Desc\t" + "Price\t" + "Qty\t" + "Subtotal\t" + "Discount\n";
        for (int i=0;i < lineItems.length; i++){
          s +=  lineItems[i].getProductID() + "\t" + lineItems[i].getProductName() + "\t"
                + formatter.format(lineItems[i].getProduct().getUnitCost()) + "\t"  
                + lineItems[i].getProdQty() + "\t" 
                + formatter.format(lineItems[i].getExtendedPrice()) + "\t"
                + formatter.format(lineItems[i].getDiscount()) + "\t\n";
        }
          s += "\n\t\tTotal Before Discount: " + "\t" + formatter.format(getTotalBeforeDiscount()) + "\n";
          s += "\t\tTotal After Discount: " + "\t" + formatter.format(getTotalAfterDiscount()) + "\n";
          s += "\t\tTotal Saved: " + "\t\t" + formatter.format(getTotalDiscount());
        
        System.out.println(s);
    }    
    public static void main(String[] args) {
        // Expect .15 discount because qty >= 5
        Receipt receipt = new Receipt("100");
        receipt.addProductToSale("A101", 6);
        receipt.addProductToSale("B205", 4);
        receipt.outputReceipt();
    
    }
    
    
}
