package lucassfelix.ilegra.prova;

import lucassfelix.ilegra.prova.dataBuilders.BusinessBuilder;
import lucassfelix.ilegra.prova.dataBuilders.ItemBuilder;
import lucassfelix.ilegra.prova.dataBuilders.SaleBuilder;
import lucassfelix.ilegra.prova.dataBuilders.SalesmanBuilder;
import lucassfelix.ilegra.prova.dataObjects.Business;
import lucassfelix.ilegra.prova.dataObjects.Sale;
import lucassfelix.ilegra.prova.dataObjects.Salesman;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    private static final String DATA_DELIMITER = "ç";
    private static final String WHITESPACE_BETWEEN_DATA = " 0";
    private static final String LINE_BREAK = "\\n";
    private static final String SALE_DELIMITER = ",";
    private static final String BRACKETS = "ç\\[|]ç";
    private static final String ITEM_DELIMITER = "-";

    public DataFile readFile(Path filePath)
    {
        try(Scanner sc = new Scanner(new File(String.valueOf(filePath)))
                .useDelimiter(WHITESPACE_BETWEEN_DATA + "|"+ LINE_BREAK +
                        "|" + BRACKETS + "|" + DATA_DELIMITER))
        {

            List<Salesman> salesmanList = new ArrayList<>();
            List<Business> businessList = new ArrayList<>();
            List<Sale> saleList = new ArrayList<>();

            while (sc.hasNext())
            {
                //sc.hasNextInteger;
                int id = Integer.parseInt(sc.next().trim());
//                int id = 0;
                switch (id) {
                    case 1:
                        Salesman newSalesman = parseSalesman(sc);
                        salesmanList.add(newSalesman);
                        break;
                    case 2:
                        Business newBusiness = parseBusiness(sc);
                        businessList.add(newBusiness);
                        break;
                    case 3:
                        Sale newSale = parseSale(sc);
                        saleList.add(newSale);
                        break;
                    default:
                }
            }

            return new DataFile(salesmanList,businessList,saleList);

        }catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    private Salesman parseSalesman(Scanner sc) {
        return SalesmanBuilder.builder()
                .withCPF(sc.next())
                .withName(sc.next())
                .withSalary(sc.next())
                .build();
    }

    private Business parseBusiness(Scanner sc) {
        return BusinessBuilder.builder()
                .withCNPJ(sc.next().trim())
                .withName(sc.next())
                .withBussinessArea(sc.next())
                .build();
    }

    private Sale parseSale(Scanner sc) {
        SaleBuilder builder = SaleBuilder.builder().withSaleId(sc.next());
        String[] items = sc.next().split(SALE_DELIMITER);
        for (int i = 0; i < items.length; i++) {
            String[] itemProprieties = items[0].split(ITEM_DELIMITER);
            builder.withNewItem(
                    ItemBuilder.builder()
                    .withItemId(itemProprieties[0])
                    .withItemQuantity(itemProprieties[1])
                    .withItemPrice(itemProprieties[2])
                    .build());
        }
        return builder.withSalesmanName(sc.next()).build();
    }

}
