package lucassfelix.ilegra.prova;

import lucassfelix.ilegra.prova.dataBuilders.ItemBuilder;
import lucassfelix.ilegra.prova.dataBuilders.SaleBuilder;
import lucassfelix.ilegra.prova.dataObjects.Item;
import lucassfelix.ilegra.prova.dataObjects.Sale;
import org.junit.Assert;
import org.junit.Test;

public class SaleBuilderTest {

    @Test
    public void shouldCreateSale()
    {
        int saleId = 01;
        String testSalesmanName = "Bruno";

        int testId = 02;
        int testQuantity = 10;
        int testPrice = 1;

        Item newItem = ItemBuilder.builder()
                .withItemId(testId)
                .withItemPrice(testPrice)
                .withItemQuantity(testQuantity)
                .build();


        Sale newSale = SaleBuilder.builder()
                .withSaleId(saleId)
                .withNewItem(newItem)
                .withSalesmanName(testSalesmanName)
                .build();

        Assert.assertNotNull(newSale);
        Assert.assertEquals(saleId,newSale.getSaleId());
        Assert.assertEquals(testSalesmanName,newSale.getSalesmanName());
        Assert.assertEquals(newItem,newSale.getSales().get(0));
    }


    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionEmptyBuild()
    {
        SaleBuilder.builder().build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionEmptyId()
    {
        Item testItem = new Item();
        SaleBuilder.builder().withNewItem(testItem).withSalesmanName("João").build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionEmptySalesmanName()
    {
        Item testItem = new Item();
        SaleBuilder.builder().withSaleId(1).withNewItem(testItem).build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionEmptyItemList()
    {
        SaleBuilder.builder().withSaleId(1).withSalesmanName("Lucas").build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionNegativeId()
    {
        Item testItem = new Item();
        SaleBuilder.builder()
                .withSaleId(-1)
                .withNewItem(testItem)
                .withSalesmanName("Marco")
                .build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionInvalidSalesmanName()
    {
        Item testItem = new Item();
        SaleBuilder.builder()
                .withSaleId(1)
                .withNewItem(testItem)
                .withSalesmanName("1234")
                .build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionNullName()
    {
        Item testItem = new Item();
        SaleBuilder.builder()
                .withSaleId(1)
                .withNewItem(testItem)
                .withSalesmanName(null)
                .build();
    }

}
