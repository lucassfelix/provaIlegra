package lucassfelix.ilegra.prova.dataBuilders;

import lucassfelix.ilegra.prova.FailedBuildException;
import lucassfelix.ilegra.prova.dataObjects.Item;
import lucassfelix.ilegra.prova.dataObjects.Sale;

import java.util.Optional;
import java.util.Scanner;

public class SaleBuilder {

    private Sale sale;
    private static final String NAME_REGEX = "^(?![ .]+$)[a-zA-Z .]*$";

    private SaleBuilder()
    {
        this.sale = new Sale();
    }

    public static SaleBuilder builder()
    {
        return new SaleBuilder();
    }

    public SaleBuilder withSaleId(int saleId)
    {
        sale.setSaleId(saleId);
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

    private boolean validateID()
    {
        if(Optional.ofNullable(sale).map(Sale::getSaleId).isPresent()
                && sale.getSaleId() > 0)
            return true;
        else
            return false;
    }

    private boolean validateName()
    {
        if(Optional.ofNullable(sale).map(Sale::getSalesmanName).isPresent()
                && sale.getSalesmanName().matches(NAME_REGEX))
            return true;
        else
            return false;
    }

    private boolean validateItems()
    {
        if(Optional.ofNullable(sale).map(Sale::getSales).isPresent()
                && sale.getSales().size() > 0)
            return true;
        else
            return false;
    }

    public Sale build()
    {
        if(!validateName())
            throw new FailedBuildException("Invalid salesman who made sale name.");

        if(!validateID())
            throw new FailedBuildException("Invalid sale ID.");

        if(!validateItems())
            throw new FailedBuildException("Invalid sale items.(Empty or nonexistent.)");

        return this.sale;
    }

}
