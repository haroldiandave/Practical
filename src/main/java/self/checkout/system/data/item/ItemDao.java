package self.checkout.system.data.item;

import self.checkout.system.appl.model.item.Item;

import java.util.List;

public interface ItemDao {
    List<Item> getAllItem();

    Item getItemById(int id);


}
