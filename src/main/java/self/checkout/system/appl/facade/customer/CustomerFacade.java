package self.checkout.system.appl.facade.customer;

import self.checkout.system.appl.model.customer.Customer;

import java.util.List;

public interface CustomerFacade {

    List<Customer> getAllCustomer();

    Customer getCustomerById(int customer_id);

}
