package self.checkout.system.appl.facade.customer.Impl;

import self.checkout.system.appl.facade.customer.CustomerFacade;
import self.checkout.system.appl.model.customer.Customer;
import self.checkout.system.data.customer.CustomerDao;

import java.util.List;

public class CustomerFacadeImpl implements CustomerFacade {

    private final CustomerDao customerDao;

    public CustomerFacadeImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public List<Customer> getAllCustomer() { return customerDao.getAllCustomer(); }


    @Override
    public Customer getCustomerById(int customer_id) throws RuntimeException {
        return customerDao.getCustomerById(customer_id);
    }


}
