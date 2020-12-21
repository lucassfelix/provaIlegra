package lucassfelix.ilegra.prova;

public class SaleBuilder {

    private Sale sale;
    private ItemBuilder itemBuilder;

    private SaleBuilder()
    {
        this.sale = new Sale();
    }

    private static SaleBuilder builder()
    {
        return new SaleBuilder();
    }

    private SaleBuilder withSaleId(String saleId)
    {
        sale.setSaleId(Integer.parseInt(saleId));
        return this;
    }

    private SaleBuilder withSalesmanName(String salesmanName)
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
