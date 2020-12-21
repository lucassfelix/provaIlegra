package lucassfelix.ilegra.prova;

public class BussinessBuilder {

    private Bussiness bussiness;

    public BussinessBuilder()
    {
        this.bussiness = new Bussiness();
    }

    public static BussinessBuilder builder()
    {
        return new BussinessBuilder();
    }

    public BussinessBuilder withName(String name)
    {
        bussiness.setName(name);
        return this;
    }

    public BussinessBuilder withCNPJ(String cnpj)
    {
        bussiness.setCnpj(cnpj);
        return this;
    }

    public BussinessBuilder withBussinessArea(String bussinessArea)
    {
        bussiness.setBussinessArea(bussinessArea);
        return this;
    }

    public Bussiness build()
    {
        return bussiness;
    }

}
