package lucassfelix.ilegra.prova;

import lucassfelix.ilegra.prova.dataBuilders.BusinessBuilder;
import lucassfelix.ilegra.prova.dataBuilders.ItemBuilder;
import lucassfelix.ilegra.prova.dataObjects.Business;
import lucassfelix.ilegra.prova.dataObjects.Item;
import org.junit.Assert;
import org.junit.Test;

public class ItemBuilderTest {

    private static final double DELTA = 0.1;

    @Test
    public void shouldCreateItem()
    {
        int testId = 02;
        int testQuantity = 10;
        int testPrice = 1;

        Item newItem = ItemBuilder.builder()
                .withItemId(testId)
                .withItemPrice(testPrice)
                .withItemQuantity(testQuantity)
                .build();

        Assert.assertNotNull(newItem);
        Assert.assertEquals(testId,newItem.getItemId());
        Assert.assertEquals(testPrice,newItem.getPrice(),DELTA);
        Assert.assertEquals(testQuantity,newItem.getQuantity());
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionEmptyBuild()
    {
        ItemBuilder.builder().build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionEmptyId()
    {
        ItemBuilder.builder().withItemQuantity(10).withItemPrice(100.0).build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionEmptyQuantity()
    {
        ItemBuilder.builder().withItemId(1).withItemPrice(100.0).build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionEmptyPrice()
    {
        ItemBuilder.builder().withItemId(1).withItemQuantity(10).build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionInvalidNegativeId()
    {
        ItemBuilder.builder()
                .withItemId(-1)
                .withItemQuantity(100)
                .withItemPrice(10.0)
                .build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionInvalidNegativeQuantity()
    {
        ItemBuilder.builder()
                .withItemPrice(100.0)
                .withItemId(1)
                .withItemQuantity(-10)
                .build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionInvalidNegativePrice()
    {
        ItemBuilder.builder()
                .withItemId(1)
                .withItemQuantity(10)
                .withItemPrice(-100.0)
                .build();
    }

}
