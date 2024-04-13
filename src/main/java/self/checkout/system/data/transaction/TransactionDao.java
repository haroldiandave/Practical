package self.checkout.system.data.transaction;

import self.checkout.system.appl.model.customer.Customer;
import self.checkout.system.appl.model.transaction.Transaction;

import java.sql.ResultSet;
import java.util.List;

public interface TransactionDao {

    List<Transaction> getAllTransaction();

    Transaction getTransactionById(int transaction_number);

    boolean addTransaction(Transaction transaction);

    List<Transaction> addTransaction(ResultSet rs);

    boolean updateTransaction(Transaction transaction);

}
