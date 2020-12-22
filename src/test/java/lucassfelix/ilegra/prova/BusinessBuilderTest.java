package lucassfelix.ilegra.prova;

import lucassfelix.ilegra.prova.dataBuilders.BusinessBuilder;
import lucassfelix.ilegra.prova.dataObjects.Business;
import org.junit.Assert;
import org.junit.Test;

public class BusinessBuilderTest {

    @Test
    public void shouldCreateBusiness()
    {
        String testName = "Lucas";
        String testCNPJ = "11111111111111";
        String testBusinessArea = "Rural";

        Business newBusiness = BusinessBuilder.builder()
                .withName(testName)
                .withCNPJ(testCNPJ)
                .withBussinessArea(testBusinessArea)
                .build();

        Assert.assertNotNull(newBusiness);
        Assert.assertEquals(testName,newBusiness.getName());
        Assert.assertEquals(testCNPJ,newBusiness.getCnpj());
        Assert.assertEquals(testBusinessArea,newBusiness.getBussinessArea());
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionEmptyBuild()
    {
        BusinessBuilder.builder().build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionEmptyName()
    {
        BusinessBuilder.builder().withCNPJ("11111111111111").withBussinessArea("Rural").build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionEmptyCNPJ()
    {
        BusinessBuilder.builder().withName("Marco").withBussinessArea("Rural").build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionEmptyBusinessArea()
    {
        BusinessBuilder.builder().withCNPJ("11111111111111").withName("Lucas").build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionInvalidCNPJTooManyNumbers()
    {
        BusinessBuilder.builder()
                .withName("Lucas")
                .withCNPJ("11111111111111111")
                .withBussinessArea("Rural")
                .build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionInvalidCNPJTooFewNumbers()
    {
        BusinessBuilder.builder()
                .withName("Lucas")
                .withCNPJ("1111111111")
                .withBussinessArea("Rural")
                .build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionInvalidCNPJLetters()
    {
        BusinessBuilder.builder()
                .withName("Lucas")
                .withCNPJ("1111111ABC1111")
                .withBussinessArea("Rural")
                .build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionInvalidNameNumbers()
    {
        BusinessBuilder.builder()
                .withName("Luca132s")
                .withCNPJ("11111111111111")
                .withBussinessArea("Rural")
                .build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionInvalidBusinessAreaNumbers()
    {
        BusinessBuilder.builder()
                .withName("Lucas")
                .withCNPJ("11111111111111")
                .withBussinessArea("Rura123l")
                .build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionNullName()
    {
        BusinessBuilder.builder()
                .withName(null)
                .withCNPJ("11111111111111")
                .withBussinessArea("Rural")
                .build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionNullCNPJ()
    {
        BusinessBuilder.builder()
                .withName("Lucas")
                .withCNPJ(null)
                .withBussinessArea("Rural")
                .build();
    }

    @Test(expected = FailedBuildException.class)
    public void shouldThrowExceptionNullBusinessArea()
    {
        BusinessBuilder.builder()
                .withName("Lucas")
                .withCNPJ("11111111111111")
                .withBussinessArea(null)
                .build();
    }



}
