package self.checkout.system.data.customer.Impl;


import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import self.checkout.system.appl.model.customer.Customer;
import self.checkout.system.data.connection.ConnectionHelper;
import self.checkout.system.data.customer.CustomerDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static self.checkout.system.data.utils.QueryConstant.GET_ALL_CUSTOMER_STATEMENT;
import static self.checkout.system.data.utils.QueryConstant.GET_CUSTOMER_BY_CUSTOMER_ID_STATEMENT;


public class CustomerDaoImpl implements CustomerDao {

    public static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CustomerDaoImpl.class);

    Connection con = ConnectionHelper.getConnection();

    @Override
    public List<Customer> getAllCustomer() {

        List<Customer> customers = new ArrayList<>();

        try (Connection con = ConnectionHelper.getConnection()){
            PreparedStatement stmt = con.prepareStatement(GET_ALL_CUSTOMER_STATEMENT);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                customers.add(setCustomer(rs));
            }
            return customers;

        } catch (Exception e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("Customer database is empty.");
        return customers;
    }

    @Override
    public Customer getCustomerById(int customer_id) {

        try (Connection con = ConnectionHelper.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(GET_CUSTOMER_BY_CUSTOMER_ID_STATEMENT);
            stmt.setInt(1, customer_id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return setCustomer(rs);
            }
        } catch (Exception e) {
            LOGGER.error("Error retrieving Customer with ID " + customer_id + ": " + e.getMessage());
            e.printStackTrace();
        }
        LOGGER.debug("Customer not found.");
        return null;
    }

    public Customer setCustomer(ResultSet rs) {
        try{
            Customer customer = new Customer();
            customer.setCustomer_id(rs.getInt("customer_id"));
            customer.setCustomer_name(rs.getString("customer_name"));
            customer.setAddress(rs.getString("address"));
            customer.setContact_no(rs.getInt("contact_no"));
            return customer;
        }catch(Exception e){
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("set Student failed.");
        return setCustomer(rs);
    }


}
