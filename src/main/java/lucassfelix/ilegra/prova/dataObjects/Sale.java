package lucassfelix.ilegra.prova.dataObjects;

import java.util.ArrayList;
import java.util.List;

public class Sale {

    private int saleId;

    private List<Item> sales;

    private String salesmanName;

    public Sale()
    {
        sales = new ArrayList<Item>();
    }

    public double calculateSalePrice()
    {
        return sales.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .max().getAsDouble();
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public void addNewSale(Item sale) {
        this.sales.add(sale);
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public int getSaleId() {
        return saleId;
    }

    public List<Item> getSales() {
        return sales;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleId=" + saleId +
                ", sales=" + sales +
                ", salesmanName='" + salesmanName + '\'' +
                '}';
    }
}
