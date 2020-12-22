package lucassfelix.ilegra.prova.dataBuilders;

import lucassfelix.ilegra.prova.FailedBuildException;
import lucassfelix.ilegra.prova.dataObjects.Salesman;

import java.util.Optional;


public class SalesmanBuilder {

    private Salesman salesman;
    private static final String ELEVEN_DIGIT_NUMBER_REGEX = "[0-9]{11}";
    private static final String NAME_REGEX = "^(?![ .]+$)[a-zA-Z .]*$";

    public SalesmanBuilder()
    {
        this.salesman = new Salesman();
    }

    public static SalesmanBuilder builder()
    {
        return new SalesmanBuilder();
    }

    public SalesmanBuilder withName(String name)
    {
        salesman.setName(name);
        return this;
    }

    public SalesmanBuilder withCPF(String cpf)
    {
        salesman.setCpf(cpf);
        return this;
    }

    public SalesmanBuilder withSalary(Double salary)
    {
        salesman.setSalary(salary);
        return this;
    }

    private boolean validateName()
    {
        if(Optional.ofNullable(salesman).map(Salesman::getName).isPresent()
                && salesman.getName().matches(NAME_REGEX))
            return true;
        else
            return false;
    }

    private boolean validateCPF()
    {
        if(Optional.ofNullable(salesman).map(Salesman::getCpf).isPresent()
                && salesman.getCpf().matches(ELEVEN_DIGIT_NUMBER_REGEX))
            return true;
        else
            return false;
    }

    private boolean validateSalary()
    {
        if(Optional.ofNullable(salesman).map(Salesman::getSalary).isPresent()
                && salesman.getSalary() > 0)
            return true;
        else
            return false;
    }
    public Salesman build()
    {
        if(!validateName())
            throw new FailedBuildException("Invalid salesman name.");

        if(!validateCPF())
            throw new FailedBuildException("Invalid salesman CPF.");

        if(!validateSalary())
            throw new FailedBuildException("Invalid salesman salary.");

        return this.salesman;
    }
}
