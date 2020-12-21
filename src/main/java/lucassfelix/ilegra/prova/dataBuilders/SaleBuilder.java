package lucassfelix.ilegra.prova.dataBuilders;

import lucassfelix.ilegra.prova.dataObjects.Item;
import lucassfelix.ilegra.prova.dataObjects.Sale;

public class SaleBuilder {

    private Sale sale;
    private ItemBuilder itemBuilder;

    private SaleBuilder()
    {
        this.sale = new Sale();
    }

    public static SaleBuilder builder()
    {
        return new SaleBuilder();
    }

    public SaleBuilder withSaleId(String saleId)
    {
        sale.setSaleId(Integer.parseInt(saleId));
        return this;
    }

    public SaleBuilder withSalesmanName(String salesmanName)
    {
        sale.setSalesmanName(salesmanName);
        return this;
    }

    public SaleBuilder withNewItem(Item newItem)
    {
        sale.addNewSale(newItem);
        return this;
    }

    public Sale build()
    {
        return sale;
    }

}
