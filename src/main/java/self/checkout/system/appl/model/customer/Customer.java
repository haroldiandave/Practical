package self.checkout.system.appl.model.customer;

public class Customer {

    private int customer_id;

    private String customer_name;

    private String address;

    private int contact_no;

    public Customer() {

    }

    public Customer(int customer_id, String customer_name, String address, Integer contact_no) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.address = address;
        this.contact_no = contact_no;
    }

    public int getCustomer_id() {return customer_id; }

    public void setCustomer_id(int customer_id) {this.customer_id = customer_id;}

    public String getCustomer_name() {return customer_name;}

    public void setCustomer_name(String customer_name) {this.customer_name = customer_name;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public Integer getContact_no() {return contact_no;}

    public void setContact_no(Integer contact_no) {this.contact_no = contact_no;}
}
