package lucassfelix.ilegra.prova.dataBuilders;

import lucassfelix.ilegra.prova.dataObjects.Business;

public class BusinessBuilder {

    private Business business;

    public BusinessBuilder()
    {
        this.business = new Business();
    }

    public static BusinessBuilder builder()
    {
        return new BusinessBuilder();
    }

    public BusinessBuilder withName(String name)
    {
        business.setName(name);
        return this;
    }

    public BusinessBuilder withCNPJ(String cnpj)
    {
        business.setCnpj(cnpj);
        return this;
    }

    public BusinessBuilder withBussinessArea(String bussinessArea)
    {
        business.setBussinessArea(bussinessArea);
        return this;
    }

    public Business build()
    {
        return business;
    }

}
