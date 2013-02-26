
/**
 *
 * @author jamesb
 */
public class Customer {
    private String custId;
    private String fullName;
    
    public Customer() {
    }

    public Customer(String cId, String name) {
        custId = cId;
        fullName = name;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public static void main(String[] args) {
        // Expect .15 discount because qty >= 5
        Customer customer = new Customer("100","John Smith");
        System.out.println("CustomerID: " + customer.getCustId());
        System.out.println("Customer: " + customer.getFullName());
    }    
    
}
