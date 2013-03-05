/**
 * This class defines the customer and provides the methods to get the customer name
 * using the customer ID number
 * 
 * @author Jim Birchfield
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
}
