package lucassfelix.ilegra.prova;

import lucassfelix.ilegra.prova.dataBuilders.BusinessBuilder;
import lucassfelix.ilegra.prova.dataBuilders.ItemBuilder;
import lucassfelix.ilegra.prova.dataBuilders.SaleBuilder;
import lucassfelix.ilegra.prova.dataBuilders.SalesmanBuilder;
import lucassfelix.ilegra.prova.dataObjects.Business;
import lucassfelix.ilegra.prova.dataObjects.DataFile;
import lucassfelix.ilegra.prova.dataObjects.Item;
import lucassfelix.ilegra.prova.dataObjects.Sale;
import lucassfelix.ilegra.prova.dataObjects.Salesman;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileReader {

    private static final String DATA_DELIMITER = "ç";
    private static final String WHITESPACE_BETWEEN_DATA = " 0";
    private static final String LINE_BREAK = "\\n";
    private static final String SALE_DELIMITER = ",";
    private static final String BRACKETS = "ç\\[|]ç";
    private static final String ITEM_DELIMITER = "-";
    private static final String ALL_AFTER_DOT_REGEX = "[.].+$";

    public static DataFile readFile(Path filePath) throws InvalidInputException
    {
        try(Scanner sc = new Scanner(new File(String.valueOf(filePath)))
                .useDelimiter(WHITESPACE_BETWEEN_DATA + "|"+ LINE_BREAK +
                        "|" + BRACKETS + "|" + DATA_DELIMITER))
        {
            String fileName = filePath.getFileName().toString().replaceFirst(ALL_AFTER_DOT_REGEX,"");
            System.out.println("Reading " + fileName);
            List<Salesman> salesmanList = new ArrayList<>();
            List<Business> businessList = new ArrayList<>();
            List<Sale> saleList = new ArrayList<>();

            while (sc.hasNext())
            {
                if(!sc.hasNextInt())
                    throw new InvalidInputException("Input format invalid.");

                int id = sc.nextInt();

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

            sc.close();
            return new DataFile(fileName,salesmanList,businessList,saleList);

        }catch (IOException e)
        {
            e.printStackTrace();
        }catch (NoSuchElementException e)
        {
            throw new InvalidInputException("Input format caused errors.");
        }catch (NumberFormatException e)
        {
            throw new InvalidInputException("Input formatting is invalid.");
        }catch (FailedBuildException e)
        {
            throw new FailedBuildException(e.getMessage() + " Located in " + filePath + ".");
        }

        return null;
    }

    private static Salesman parseSalesman(Scanner sc) {
        SalesmanBuilder builder = SalesmanBuilder.builder()
                .withCPF(sc.next())
                .withName(sc.next());

        if(!sc.hasNextDouble())
            throw new InvalidInputException("Input salary format invalid.");

        return builder.withSalary(sc.nextDouble())
                .build();
    }

    private static Business parseBusiness(Scanner sc) {
        return BusinessBuilder.builder()
                .withCNPJ(sc.next())
                .withName(sc.next())
                .withBussinessArea(sc.next())
                .build();
    }

    private static Sale parseSale(Scanner sc) {

        if(!sc.hasNextInt())
            throw new InvalidInputException("Input sale id formatting is invalid.");

        SaleBuilder saleBuilder = SaleBuilder.builder().withSaleId(sc.nextInt());
        String[] items = sc.next().split(SALE_DELIMITER);
        for (int i = 0; i < items.length; i++) {
            String[] itemProprieties = items[0].split(ITEM_DELIMITER);
            int itemId = Integer.parseInt(itemProprieties[0]);
            int itemQuantity = Integer.parseInt(itemProprieties[1]);
            double itemPrice = Double.parseDouble(itemProprieties[2]);
            saleBuilder.withNewItem(
                    ItemBuilder.builder()
                            .withItemId(itemId)
                            .withItemQuantity(itemQuantity)
                            .withItemPrice(itemPrice)
                            .build());
        }
        return saleBuilder.withSalesmanName(sc.next()).build();
    }

}
