package self.checkout.system.appl.model.item;

public class Item {

    private int id;

    private String description;

    private int price;

    private int quantity;

    public Item() {
    }

    public Item(int id, String description, Integer price, Integer quantity) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {return price;}

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
