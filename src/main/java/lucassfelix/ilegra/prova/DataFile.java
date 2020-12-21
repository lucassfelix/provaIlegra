package lucassfelix.ilegra.prova;

import lucassfelix.ilegra.prova.dataObjects.Business;
import lucassfelix.ilegra.prova.dataObjects.Sale;
import lucassfelix.ilegra.prova.dataObjects.Salesman;

import java.util.List;

public class DataFile {

    private List<Salesman> salesmanList;
    private List<Business> businessList;
    private List<Sale> saleList;

    public DataFile(List<Salesman> salesmanList, List<Business> businessList, List<Sale> saleList) {
        this.salesmanList = salesmanList;
        this.businessList = businessList;
        this.saleList = saleList;
    }

    private int clientAmount()
    {
        return businessList.size();
    }

    private int salesmanAmount()
    {
        return salesmanList.size();
    }

    private int mostExpensiveSaleId()
    {
        return 0;
    }

    private Salesman worstSalesmanEver()
    {

        return null;
    }

    public void processFile()
    {

    }
}
