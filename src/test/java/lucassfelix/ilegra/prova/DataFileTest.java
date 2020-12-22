package lucassfelix.ilegra.prova;

import lucassfelix.ilegra.prova.dataObjects.Business;
import lucassfelix.ilegra.prova.dataObjects.DataFile;
import lucassfelix.ilegra.prova.dataObjects.Salesman;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DataFileTest {

    @Test
    public void shouldReturnCorrectSalesmanAmount()
    {
        List<Salesman> mockSalesmanList = new ArrayList<>();
        Salesman mockSalesman = new Salesman();
        mockSalesman.setName("Lucas");
        mockSalesman.setCpf("012");
        mockSalesman.setSalary(1000.0);
        mockSalesmanList.add(mockSalesman);

        DataFile mockDataFile = new DataFile("test",mockSalesmanList,null,null);

        int actualCount = mockDataFile.salesmanAmount();

        Assert.assertEquals(actualCount,mockSalesmanList.size());

        mockSalesmanList.clear();
        actualCount = mockDataFile.salesmanAmount();

        Assert.assertEquals(actualCount,mockSalesmanList.size());
    }

    @Test
    public void shouldReturnCorrectClientAmount()
    {
        List<Business> mockBusinessList = new ArrayList<>();
        Business mockBusiness = new Business();
        mockBusiness.setName("Lucas");
        mockBusiness.setCnpj("012");
        mockBusiness.setBussinessArea("Iha");
        mockBusinessList.add(mockBusiness);

        DataFile mockDataFile = new DataFile("test",null,mockBusinessList,null);

        int actualCount = mockDataFile.clientAmount();

        Assert.assertEquals(actualCount,mockBusinessList.size());

        mockBusinessList.clear();
        actualCount = mockDataFile.clientAmount();

        Assert.assertEquals(actualCount,mockBusinessList.size());
    }

}
