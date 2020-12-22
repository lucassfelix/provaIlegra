package lucassfelix.ilegra.prova;

import lucassfelix.ilegra.prova.dataBuilders.SalesmanBuilder;
import lucassfelix.ilegra.prova.dataObjects.Salesman;
import org.junit.Assert;
import org.junit.Test;

public class SalesmanBuilderTest {

    private static final double DELTA = 0.1;

    @Test
    public void shouldCreateSalesman()
    {
        String testName = "Lucas";
        String testCPF = "11111111111";
        double testSalary = 1000.0;

        Salesman newSalesman = SalesmanBuilder.builder()
                .withName(testName)
                .withCPF(testCPF)
                .withSalary(testSalary)
                .build();

        Assert.assertNotNull(newSalesman);
        Assert.assertEquals(testName,newSalesman.getName());
        Assert.assertEquals(testCPF,newSalesman.getCpf());
        Assert.assertEquals(testSalary,newSalesman.getSalary(),DELTA);
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionEmptyBuild()
    {
        SalesmanBuilder.builder().build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionEmptyName()
    {
        SalesmanBuilder.builder().withCPF("11111111111").withSalary(1000.0).build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionEmptyCPF()
    {
        SalesmanBuilder.builder().withName("Marco").withSalary(1000.0).build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionEmptySalary()
    {
        SalesmanBuilder.builder().withCPF("11111111111").withName("Lucas").build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionInvalidCPFTooManyNumbers()
    {
        SalesmanBuilder.builder()
                .withName("Lucas")
                .withCPF("11111111111111111")
                .withSalary(1000.0)
                .build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionInvalidCPFTooFewNumbers()
    {
        SalesmanBuilder.builder()
                .withName("Lucas")
                .withCPF("111111111")
                .withSalary(1000.0)
                .build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionInvalidCPFLetters()
    {
        SalesmanBuilder.builder()
                .withName("Lucas")
                .withCPF("1111ABC1111")
                .withSalary(1000.0)
                .build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionInvalidNameNumbers()
    {
        SalesmanBuilder.builder()
                .withName("Luca132s")
                .withCPF("11111111111")
                .withSalary(1000.0)
                .build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionInvalidSalaryNegative()
    {
        SalesmanBuilder.builder()
                .withName("Lucas")
                .withCPF("11111111111")
                .withSalary(-1000.0)
                .build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionNullName()
    {
        SalesmanBuilder.builder()
                .withName(null)
                .withCPF("11111111111")
                .withSalary(1000.0)
                .build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionNullCPF()
    {
        SalesmanBuilder.builder()
                .withName("Lucas")
                .withCPF(null)
                .withSalary(1000.0)
                .build();
    }

}
