/**
 * This class with the main method executes the Discount Strategy application
 * 
 * @author Jim Birchfield
 */
public class Startup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CashRegister cr1 = new CashRegister();
        cr1.startNewSale("100");
        cr1.addItemToSale("A101", 6);
        cr1.addItemToSale("B205", 4);
        cr1.addItemToSale("C222", 6);
        cr1.finalizeSale();
        CashRegister cr2 = new CashRegister();
        cr2.startNewSale("200");
        cr2.addItemToSale("A101", 2);
        cr2.addItemToSale("B205", 1);
        cr2.addItemToSale("C222", 1);
        cr2.finalizeSale();
    }
}
