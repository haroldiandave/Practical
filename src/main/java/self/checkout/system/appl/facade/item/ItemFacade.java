package self.checkout.system.appl.facade.item;

import self.checkout.system.appl.model.item.Item;

import java.util.List;

public interface ItemFacade {

    List<Item> getAllItem();

    Item getItemById(int id);
}
