package self.checkout.system.data.customer;

import self.checkout.system.appl.model.customer.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> getAllCustomer();

    Customer getCustomerById(int customer_id);
}
