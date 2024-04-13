package self.checkout.system.appl.facade.transaction;

import self.checkout.system.appl.model.customer.Customer;
import self.checkout.system.appl.model.transaction.Transaction;

import java.util.List;

public interface TransactionFacade {

    List<Transaction> getAllTransaction();

    Transaction getTransactionById(int transaction_number);

    boolean addTransaction(Transaction transaction);

    boolean updateTransaction(Transaction transaction);

}
