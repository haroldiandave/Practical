package self.checkout.system.data.item.Impl;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

import self.checkout.system.appl.model.item.Item;
import self.checkout.system.data.connection.ConnectionHelper;

import self.checkout.system.data.item.ItemDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static self.checkout.system.data.utils.QueryConstant.GET_ALL_ITEM_STATEMENT;
import static self.checkout.system.data.utils.QueryConstant.GET_ITEM_BY_ITEM_ID_STATEMENT;


public class ItemDaoImpl implements ItemDao {

    public static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ItemDaoImpl.class);

    Connection con = ConnectionHelper.getConnection();


    @Override
    public List<Item> getAllItem() {

        List<Item> item = new ArrayList<>();

        try (Connection con = ConnectionHelper.getConnection()){
            PreparedStatement stmt = con.prepareStatement(GET_ALL_ITEM_STATEMENT);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                item.add(setItems(rs));
            }
            return item;

        } catch (Exception e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("Customer database is empty.");
        return item;
    }

    @Override
    public Item getItemById(int id) {

        try (Connection con = ConnectionHelper.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(GET_ITEM_BY_ITEM_ID_STATEMENT);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return setItems(rs);
            }
        } catch (Exception e) {
            LOGGER.error("Error retrieving Item with ID " + id + ": " + e.getMessage());
            e.printStackTrace();
        }
        LOGGER.debug("Item not found.");
        return null;
    }

    public Item setItems(ResultSet rs) {
        try{
            Item item = new Item();
            item.setId(rs.getInt("id"));
            item.setDescription(rs.getString("description"));
            item.setPrice(rs.getInt("price"));
            item.setQuantity(rs.getInt("quantity"));
            return item;
        }catch(Exception e){
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("set Student failed.");
        return setItems(rs);
    }

}
