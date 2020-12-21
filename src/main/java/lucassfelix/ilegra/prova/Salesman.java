package lucassfelix.ilegra.prova;

public class Salesman {

    private String cpf;
    private String name;
    private double salary;

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Salesman " + name + ", CPF:" + cpf  +
                ", Salary = " + salary;
    }
}
