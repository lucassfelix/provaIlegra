package lucassfelix.ilegra.prova;

public class ItemBuilder {

    public Item item;

    public ItemBuilder()
    {
        this.item = new Item();
    }

    public static ItemBuilder builder()
    {
        return new ItemBuilder();
    }

    public ItemBuilder withItemId(String itemId)
    {
        item.setItemId(Integer.parseInt(itemId));
        return this;
    }

    public ItemBuilder withItemQuantity(String itemQuantity)
    {
        item.setQuantity(Integer.parseInt(itemQuantity));
        return this;
    }

    public ItemBuilder withItemPrice(String itemPrice)
    {
        item.setPrice(Integer.parseInt(itemPrice));
        return this;
    }

    public Item build()
    {
        return item;
    }

}
