package self.checkout.system.data.transaction.Impl;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

import self.checkout.system.appl.model.transaction.Transaction;
import self.checkout.system.data.connection.ConnectionHelper;
import self.checkout.system.data.transaction.TransactionDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import static self.checkout.system.data.utils.QueryConstant.*;

public class TransactionDaoImpl implements TransactionDao {

    public static final Logger LOGGER = (Logger) LoggerFactory.getLogger(TransactionDaoImpl.class);

    Connection con = ConnectionHelper.getConnection();

    @Override
    public List<Transaction> getAllTransaction() {

        List<Transaction> transactions = new ArrayList<>();

        try (Connection con = ConnectionHelper.getConnection()){
            PreparedStatement stmt = con.prepareStatement(GET_ALL_TRANSACTION_STATEMENT);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                transactions.add(setTransaction(rs));
            }
            return transactions;

        } catch (Exception e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("Transaction database is empty.");
        return transactions;

    }

    @Override
    public Transaction getTransactionById(int transaction_number) {
        try (Connection con = ConnectionHelper.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(GET_TRANSACTION_BY_TRANSACTION_ID_STATEMENT);
            stmt.setInt(1, transaction_number);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return setTransaction(rs);
            }
        } catch (Exception e) {
            LOGGER.error("Error retrieving Transaction with ID " + transaction_number + ": " + e.getMessage());
            e.printStackTrace();
        }
        LOGGER.debug("Transaction not found.");
        return null;
    }

    @Override
    public boolean addTransaction(Transaction transaction) {
        try (Connection con = ConnectionHelper.getConnection()) {
            PreparedStatement statement = con.prepareStatement(ADD_TRANSACTION_STATEMENT);
            statement.setInt(1, transaction.getCustomer_id());
            statement.setInt(2, transaction.getItem_id());
            statement.setTimestamp(3, transaction.getTrans_date());
            statement.setInt(4, transaction.getTransaction_number());
            int result = statement.executeUpdate();
            return result == 1? true: false;

        } catch (Exception e) {
            LOGGER.error("Error adding transaction failed " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Transaction> addTransaction(ResultSet rs) {return addTransaction(rs); }
    public Transaction setTransaction(ResultSet rs){
            try{
                Transaction transaction = new Transaction();
                transaction.setCustomer_id(rs.getInt("customer_id"));
                transaction.setItem_id(rs.getInt("item_id"));
                transaction.setTrans_date(rs.getTimestamp("trans_date"));
                transaction.setTransaction_number(rs.getInt("transaction_number"));
                return transaction;
            }catch(Exception e){
                LOGGER.error("An SQL Exception occurred." + e.getMessage());
            }
            LOGGER.debug("set Student failed.");
            return setTransaction(rs);
    }


    @Override
    public boolean updateTransaction(Transaction transaction) {
        try (Connection con = ConnectionHelper.getConnection()) {
            PreparedStatement statement = con.prepareStatement(UPDATE_TRANSACTION);
            statement.setInt(1, transaction.getCustomer_id());
            statement.setInt(2, transaction.getItem_id());
            statement.setTimestamp(3, transaction.getTrans_date());
            statement.setInt(4, transaction.getTransaction_number());
            int result = statement.executeUpdate();
            return result == 1;
        } catch (Exception e) {
            LOGGER.error("Error updating user with ID " + transaction.getTransaction_number() + ": " + e.getMessage());
            e.printStackTrace();
            return false;
        }

    }


}
