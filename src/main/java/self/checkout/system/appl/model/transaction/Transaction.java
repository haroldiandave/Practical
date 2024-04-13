package self.checkout.system.appl.model.transaction;

import java.sql.Timestamp;

public class Transaction {

    private int transaction_number;

    private int customer_id;

    private int item_id;

    private Timestamp trans_date;

    public Transaction(){
    }


    public int getTransaction_number() {return transaction_number;}

    public void setTransaction_number(int transaction_number) {this.transaction_number = transaction_number;}

    public Integer getCustomer_id() {return customer_id;}

    public void setCustomer_id(Integer customer_id) {this.customer_id = customer_id;}

    public Integer getItem_id() {return item_id;}

    public void setItem_id(Integer item_id) {this.item_id = item_id;}

    public Timestamp getTrans_date() {return trans_date;}

    public void setTrans_date(Timestamp trans_date) {this.trans_date = trans_date;}
}
