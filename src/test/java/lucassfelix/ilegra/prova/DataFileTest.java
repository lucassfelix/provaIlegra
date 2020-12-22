package lucassfelix.ilegra.prova;

import lucassfelix.ilegra.prova.dataBuilders.ItemBuilder;
import lucassfelix.ilegra.prova.dataBuilders.SaleBuilder;
import lucassfelix.ilegra.prova.dataBuilders.SalesmanBuilder;
import lucassfelix.ilegra.prova.dataObjects.Business;
import lucassfelix.ilegra.prova.dataObjects.DataFile;
import lucassfelix.ilegra.prova.dataObjects.Sale;
import lucassfelix.ilegra.prova.dataObjects.Salesman;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DataFileTest {

    @Test
    public void shouldReturnCorrectSalesmanAmount() {
        List<Salesman> mockSalesmanList = new ArrayList<>();
        Salesman mockSalesman = new Salesman();
        mockSalesman.setName("Lucas");
        mockSalesman.setCpf("012");
        mockSalesman.setSalary(1000.0);
        mockSalesmanList.add(mockSalesman);

        DataFile mockDataFile = new DataFile("test", mockSalesmanList, null, null);

        int actualCount = mockDataFile.salesmanAmount();

        Assert.assertEquals(actualCount, mockSalesmanList.size());

        mockSalesmanList.clear();
        actualCount = mockDataFile.salesmanAmount();

        Assert.assertEquals(actualCount, mockSalesmanList.size());
    }

    @Test
    public void shouldReturnCorrectClientAmount() {
        List<Business> mockBusinessList = new ArrayList<>();
        Business mockBusiness = new Business();
        mockBusiness.setName("Lucas");
        mockBusiness.setCnpj("012");
        mockBusiness.setBussinessArea("Iha");
        mockBusinessList.add(mockBusiness);

        DataFile mockDataFile = new DataFile("test", null, mockBusinessList, null);

        int actualCount = mockDataFile.clientAmount();

        Assert.assertEquals(actualCount, mockBusinessList.size());

        mockBusinessList.clear();
        actualCount = mockDataFile.clientAmount();

        Assert.assertEquals(actualCount, mockBusinessList.size());
    }

    @Test
    public void shouldReturnMostExpensiveSale() {

        List<Sale> mockSaleList = new ArrayList<>();
        mockSaleList.add(
                SaleBuilder.builder()
                        .withSaleId(1)
                        .withSalesmanName("Lucas")
                        .withNewItem(
                                ItemBuilder.builder()
                                        .withItemId(1)
                                        .withItemQuantity(1)
                                        .withItemPrice(10)
                                        .build()
                        ).build());

        mockSaleList.add(
                SaleBuilder.builder()
                        .withSaleId(2)
                        .withSalesmanName("Lucas")
                        .withNewItem(
                                ItemBuilder.builder()
                                        .withItemId(1)
                                        .withItemQuantity(2)
                                        .withItemPrice(10)
                                        .build()
                        ).build());

        mockSaleList.add(
                SaleBuilder.builder()
                        .withSaleId(3)
                        .withSalesmanName("Lucas")
                        .withNewItem(
                                ItemBuilder.builder()
                                        .withItemId(1)
                                        .withItemQuantity(3)
                                        .withItemPrice(10)
                                        .build()
                        ).build());

        DataFile testDataFile = new DataFile("test", null, null, mockSaleList);

        int actual = testDataFile.mostExpensiveSaleId();

        Assert.assertEquals(3, actual);
    }

    @Test
    public void shouldReturnWorstSalesman() {
        List<Salesman> mockSalesmanList = new ArrayList<>();

        mockSalesmanList.add(SalesmanBuilder.builder()
                .withName("Lucas").withCPF("00000000000").withSalary(1000.0).build());


        mockSalesmanList.add(SalesmanBuilder.builder()
                .withName("Marco").withCPF("00000000000").withSalary(1000.0).build());


        List<Sale> mockSaleList = new ArrayList<>();
        mockSaleList.add(
                SaleBuilder.builder()
                        .withSaleId(1)
                        .withSalesmanName("Marco")
                        .withNewItem(
                                ItemBuilder.builder()
                                        .withItemId(1)
                                        .withItemQuantity(1)
                                        .withItemPrice(10)
                                        .build()
                        ).build());

        mockSaleList.add(
                SaleBuilder.builder()
                        .withSaleId(2)
                        .withSalesmanName("Lucas")
                        .withNewItem(
                                ItemBuilder.builder()
                                        .withItemId(1)
                                        .withItemQuantity(2)
                                        .withItemPrice(10)
                                        .build()
                        ).build());

        mockSaleList.add(
                SaleBuilder.builder()
                        .withSaleId(3)
                        .withSalesmanName("Lucas")
                        .withNewItem(
                                ItemBuilder.builder()
                                        .withItemId(1)
                                        .withItemQuantity(3)
                                        .withItemPrice(10)
                                        .build()
                        ).build());

        DataFile testDataFile = new DataFile("test", mockSalesmanList, null, mockSaleList);

        String actual = testDataFile.worstSalesmanEver();

        Assert.assertEquals("Marco", actual);
    }

}
