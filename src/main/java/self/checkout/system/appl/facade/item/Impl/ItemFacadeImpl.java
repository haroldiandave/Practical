package self.checkout.system.appl.facade.item.Impl;

import self.checkout.system.appl.facade.item.ItemFacade;
import self.checkout.system.appl.model.item.Item;
import self.checkout.system.data.item.ItemDao;

import java.util.List;

public class ItemFacadeImpl implements ItemFacade {

    private final ItemDao itemDao;

    public ItemFacadeImpl(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Override
    public List<Item> getAllItem() { return itemDao.getAllItem(); }

    @Override
    public Item getItemById(int id) throws RuntimeException {
        return itemDao.getItemById(id);
    }

}
