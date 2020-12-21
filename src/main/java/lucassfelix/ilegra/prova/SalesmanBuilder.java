package lucassfelix.ilegra.prova;

public class SalesmanBuilder {

    private Salesman salesman;

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

    public SalesmanBuilder withSalary(String salary)
    {
        salesman.setSalary(Double.parseDouble(salary));
        return this;
    }

    public Salesman build()
    {
        return salesman;
    }
}
