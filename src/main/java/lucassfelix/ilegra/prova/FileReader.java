package lucassfelix.ilegra.prova;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    private static final String SPLIT_STRING = "ç";
    private static final String WHITESPACE_BETWEEN_DATA = " 0";
    private static final String LINE_BREAK = "\\\\n";

    public void ReadFile(Path filePath)
    {
        try(Scanner sc = new Scanner(new File(String.valueOf(filePath)))
                .useDelimiter(WHITESPACE_BETWEEN_DATA + "|"+ LINE_BREAK +"|" + SPLIT_STRING))
        {

            List<Salesman> salesmanList = new ArrayList<Salesman>();
            List<Bussiness> bussinessesList = new ArrayList<Bussiness>();


            while (sc.hasNext())
            {
                //sc.hasNextInteger;
                int id = Integer.parseInt(sc.next().trim());
                switch (id) {
                    case 1:
                        Salesman newSalesman = ParseSalesman(sc);
                        salesmanList.add(newSalesman);
                        break;
                    case 2:
                        Bussiness newBussiness = ParseBusiness(sc);
                        bussinessesList.add(newBussiness);
                        break;
                    case 3:
                        ParseSale(sc);
                        break;
                    default:
                }
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private Salesman ParseSalesman(Scanner sc) {
        return SalesmanBuilder.builder()
                .withName(sc.next())
                .withCPF(sc.next())
                .withSalary(sc.next())
                .build();
    }

    private Bussiness ParseBusiness(Scanner sc) {
        return BussinessBuilder.builder()
                .withName(sc.next())
                .withCNPJ(sc.next().trim())
                .withBussinessArea(sc.next())
                .build();
    }

    private void ParseSale(Scanner sc) {
    }

}
