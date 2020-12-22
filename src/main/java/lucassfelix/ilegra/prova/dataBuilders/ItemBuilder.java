package lucassfelix.ilegra.prova.dataBuilders;

import lucassfelix.ilegra.prova.FailedBuildException;
import lucassfelix.ilegra.prova.dataObjects.Item;
import lucassfelix.ilegra.prova.dataObjects.Sale;

import java.util.Optional;

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

    private boolean validateID()
    {
        if(Optional.ofNullable(item).map(Item::getItemId).isPresent()
                && item.getItemId() > 0)
            return true;
        else
            return false;
    }

    private boolean validateQuantity()
    {
        if(Optional.ofNullable(item).map(Item::getQuantity).isPresent()
                && item.getQuantity() > 0)
            return true;
        else
            return false;
    }

    private boolean validatePrice()
    {
        if(Optional.ofNullable(item).map(Item::getPrice).isPresent()
                && item.getPrice() > 0)
            return true;
        else
            return false;
    }

    public Item build()
    {

        if(!validatePrice())
            throw new FailedBuildException("Invalid item price.");

        if(!validateID())
            throw new FailedBuildException("Invalid item ID.");

        if(!validateQuantity())
            throw new FailedBuildException("Invalid item quantity.");

        return this.item;
    }

}
