package self.checkout.system.appl.facade.transaction.Impl;

import self.checkout.system.appl.facade.transaction.TransactionFacade;
import self.checkout.system.appl.model.transaction.Transaction;
import self.checkout.system.data.transaction.TransactionDao;

import java.util.List;

public class TransactionFacadeImpl implements TransactionFacade {

    private final TransactionDao transactionDao;

    public TransactionFacadeImpl(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    @Override
    public List<Transaction> getAllTransaction() { return transactionDao.getAllTransaction(); }

    @Override
    public Transaction getTransactionById(int transaction_number) throws RuntimeException {
        return transactionDao.getTransactionById(transaction_number);

    }

    @Override
    public boolean addTransaction(Transaction transaction) {
        boolean result = false;
        try {
            Transaction targetTransaction = getTransactionById(transaction.getTransaction_number());
            if(targetTransaction != null) {
                throw new Exception("Student to add already exists. ");
            }
            result = transactionDao.addTransaction(transaction);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean updateTransaction(Transaction transaction) {
        boolean result = false;
        try {
            Transaction targetTransaction = getTransactionById(transaction.getTransaction_number());
            if (targetTransaction == null) {
                throw new Exception("Transaction to update not found. ");
            }
            result = transactionDao.updateTransaction(transaction);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return result;

    }
}
