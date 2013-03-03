
import java.text.SimpleDateFormat;
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
        double grandTotal = 0.0;
        for(LineItem item : lineItems) {
            grandTotal += item.getExtendedPrice();
        }
        return grandTotal;
    }

    public void outputReceipt() {
        String s = "Thanks for Shopping With Us!\n\n";
        s += "Date of Receipt: " + getCurrentDate() + "\n\n";
        s += "Sold to: " + customer.getFullName()+ "\n\n";
        s += "ID\t" + "Desc\t" + "Price\t" + "Qty\t" + "Subtotal\t" + "Discount\n";
        for (int i=0;i < lineItems.length; i++){
          s +=  lineItems[i].getProductID() + "\t" + lineItems[i].getProductName() + "\t"
                + lineItems[i].getProdQty() + "\t" + lineItems[i].getExtendedPrice() + "\t"
               + lineItems[i].getProduct().getUnitCost() + "\t"  
                + lineItems[i].getDiscount() + "\t\n";
        }
        System.out.println(s);
    }    
    public static void main(String[] args) {
        // Expect .15 discount because qty >= 5
        Receipt receipt = new Receipt("100");
        System.out.println("CustID: " + receipt.customer.getCustId());
        System.out.println("Customer Name :" + receipt.customer.getFullName());
        receipt.addProductToSale("A101", 6);
        receipt.addProductToSale("B205", 4);
        receipt.outputReceipt();
    
    }
    
    
}
