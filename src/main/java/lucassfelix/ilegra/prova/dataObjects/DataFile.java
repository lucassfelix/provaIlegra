package lucassfelix.ilegra.prova.dataObjects;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DataFile {

    private String OUTPUT_FILE_EXTENSION = ".done.dat";

    private String fileName;
    private List<Salesman> salesmanList;
    private List<Business> businessList;
    private List<Sale> saleList;

    public DataFile(String fileName, List<Salesman> salesmanList, List<Business> businessList, List<Sale> saleList) {
        this.fileName = fileName;
        this.salesmanList = salesmanList;
        this.businessList = businessList;
        this.saleList = saleList;
    }

    public int clientAmount() {
        return businessList.size();
    }

    public int salesmanAmount() {
        return salesmanList.size();
    }

    public int mostExpensiveSaleId() {
        Optional<Sale> mostExpensiveSale = saleList.stream().max(Comparator.comparing(sale -> sale.calculateSalePrice()));
        if (mostExpensiveSale.isPresent())
            return mostExpensiveSale.get().getSaleId();
        else
            return -1;
    }


    public String worstSalesmanEver() {
        HashMap<String, Double> salesmanProfit = new HashMap<>();
        for (Salesman s :
                salesmanList) {
            salesmanProfit.put(s.getName(), 0.0);
        }
        for (Sale s :
                saleList) {
            salesmanProfit.put(s.getSalesmanName(), salesmanProfit.get(s.getSalesmanName()) + s.calculateSalePrice());
        }
        Map.Entry<String, Double> worstSalesmanName = Collections.min(salesmanProfit.entrySet(),
                Comparator.comparing(Map.Entry::getValue));

        return worstSalesmanName.getKey();
    }

    public void processFile(Path outputFolderPath) {
        Path outputFilePath = Paths.get(outputFolderPath.toString() + "/" + fileName + OUTPUT_FILE_EXTENSION);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(outputFilePath, StandardCharsets.UTF_8)) {
            bufferedWriter.write("Number of clients: " + clientAmount());
            bufferedWriter.newLine();
            bufferedWriter.write("Number of salesman: " + salesmanAmount());
            bufferedWriter.newLine();
            bufferedWriter.write("Most expensive sale ID: " + mostExpensiveSaleId());
            bufferedWriter.newLine();
            bufferedWriter.write("Worst salesman ever name: " + worstSalesmanEver());
            bufferedWriter.newLine();
            System.out.println("Created " + fileName + OUTPUT_FILE_EXTENSION);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
