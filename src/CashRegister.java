/**
 * This class accepts the inputs (Customer ID, Product ID, and quantity purchased,
 * and passes the inputs to the various other classes to get the information needed to
 * create the receipt.
 * 
 * @author Jim Birchfield
 */
public class CashRegister {

    
    private Receipt receipt;
    
    public CashRegister() {
    }
    
    public void startNewSale(String CustId){
        receipt = new Receipt(CustId);
        receipt.getCustomer();
    }
    
    public void addItemToSale(String prodID, int prodQty){
        receipt.addProductToSale(prodID, prodQty);
    }
    
    public void finalizeSale() {
        receipt.outputReceipt();
    }
}    