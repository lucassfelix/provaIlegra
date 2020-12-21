package lucassfelix.ilegra.prova;

import java.util.List;

public class DataFile {

    private List<Salesman> salesmanList;
    private List<Bussiness> bussinessList;

    public DataFile(List<Salesman> salesmanList, List<Bussiness> bussinessList) {
        this.salesmanList = salesmanList;
        this.bussinessList = bussinessList;
    }
}
