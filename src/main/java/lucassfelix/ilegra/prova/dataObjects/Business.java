package lucassfelix.ilegra.prova.dataObjects;

public class Business {

    private String cnpj;
    private String name;
    private String bussinessArea;

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBussinessArea(String bussinessArea) {
        this.bussinessArea = bussinessArea;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getName() {
        return name;
    }

    public String getBussinessArea() {
        return bussinessArea;
    }

    @Override
    public String toString() {
        return "Business " + name +
                ". CNPJ = " + cnpj +
                ". Bussiness Area = " + bussinessArea;
    }
}
