import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;

@RunWith(MockitoJUnitRunner.class)

public class SetBunsMockedTest {
    private Burger testBurger;

    @Before
    public void setUp() {
        testBurger = new Burger();
    }

    @Mock
    private Bun mockedBun;

    @Test

    public void burgerSetBunsNotNullTest() {
        testBurger.setBuns(mockedBun);
        Assert.assertNotNull(testBurger.bun);
    }

    @Test

    public void burgerSetBunsSetsActualBunTest() {
        testBurger.setBuns(mockedBun);
        Assert.assertSame(mockedBun, testBurger.bun);
    }

    @Test

    public void burgerSetBunsSetsCorrectBunNameTest() {
        Mockito.when(mockedBun.getName()).thenReturn("Зерновая булочка");
        testBurger.setBuns(mockedBun);
        Assert.assertEquals("Зерновая булочка", testBurger.bun.getName());
    }

    @Test

    public void burgerSetBunsSetsCorrectBunPriceTest() {
        Mockito.when(mockedBun.getPrice()).thenReturn(50f);
        testBurger.setBuns(mockedBun);
        Assert.assertEquals(50f, testBurger.bun.getPrice(), 0.01f);
    }
}