
 
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
    
                    
              
    public double getTotalBeforeDiscount() {
        double grandTotal = 0.0;
        for(LineItem item : lineItems) {
            grandTotal += item.getOrigPriceSubtotal();
        }
        return grandTotal;
    }


   
    public static void main(String[] args) {
        // Expect .15 discount because qty >= 5
        Receipt receipt = new Receipt("100");
        System.out.println("CustID: " + receipt.customer.getCustId());
        System.out.println("Customer Name :" + receipt.customer.getFullName());
    
    }
    
    
}
