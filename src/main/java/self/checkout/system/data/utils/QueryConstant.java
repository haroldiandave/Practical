package self.checkout.system.data.utils;

public class QueryConstant {

    private QueryConstant() {
    }

    /**
     * Retrieve all students from Customer table
     */
    public static final String GET_ALL_CUSTOMER_STATEMENT = "SELECT * FROM CUSTOMER";

    /**
     * Retrieve a customer by their customer ID from the CUSTOMER table
     */
    public static final String GET_CUSTOMER_BY_CUSTOMER_ID_STATEMENT = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";


    public static final String GET_ALL_ITEM_STATEMENT = "SELECT * FROM ITEM";

    public static final String GET_ITEM_BY_ITEM_ID_STATEMENT = "SELECT * FROM CUSTOMER WHERE ITEM_ID = ?";


    public static final String GET_ALL_TRANSACTION_STATEMENT = "SELECT * FROM TRANSACTION";

    public static final String GET_TRANSACTION_BY_TRANSACTION_ID_STATEMENT = "SELECT * FROM CUSTOMER WHERE ITEM_ID = ?";

    public static final String ADD_TRANSACTION_STATEMENT = "INSERT INTO TRANSACTION VALUES (?, ?, ?, ?)";

    public static final String UPDATE_TRANSACTION ="UPDATE transaction" +
            " SET customer_id = ?,  item_id = ?, trans_date = ?"
            + "  WHERE transaction_number = ?";







}
