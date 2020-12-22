package lucassfelix.ilegra.prova.dataBuilders;

import lucassfelix.ilegra.prova.FailedBuildException;
import lucassfelix.ilegra.prova.dataObjects.Business;

import java.util.Optional;

public class BusinessBuilder {

    private Business business;
    private static final String FOURTEEN_DIGIT_NUMBER_REGEX = "[0-9]{14}";
    private static final String NAME_REGEX = "^(?![ .]+$)[a-zA-Z .]*$";

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

    private boolean validateName()
    {
        if(Optional.ofNullable(business).map(Business::getName).isPresent()
                && business.getName().matches(NAME_REGEX))
            return true;
        else
            return false;
    }

    private boolean validateCNPJ()
    {
        if(Optional.ofNullable(business).map(Business::getCnpj).isPresent()
                && business.getCnpj().matches(FOURTEEN_DIGIT_NUMBER_REGEX))
            return true;
        else
            return false;
    }

    private boolean validateBusinessArea()
    {
        if(Optional.ofNullable(business).map(Business::getBussinessArea).isPresent()
                && business.getBussinessArea().matches(NAME_REGEX))
            return true;
        else
            return false;
    }

    public Business build()
    {
        if(!validateName())
            throw new FailedBuildException("Invalid business name.");

        if(!validateCNPJ())
            throw new FailedBuildException("Invalid business CNPJ.");

        if(!validateBusinessArea())
            throw new FailedBuildException("Invalid business Area.");

        return this.business;
    }

}
