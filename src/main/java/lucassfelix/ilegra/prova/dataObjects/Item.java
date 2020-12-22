package lucassfelix.ilegra.prova.dataObjects;

public class Item{
    private int itemId;
    private int quantity;
    private double price;

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
