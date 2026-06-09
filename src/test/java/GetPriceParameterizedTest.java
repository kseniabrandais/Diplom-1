import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

@RunWith(Parameterized.class)

public class GetPriceParameterizedTest {

    private final float bunPrice;
    private final Float ingredientPrice;
    private final Float secondIngredientPrice;
    private final float expectedPrice;

    public GetPriceParameterizedTest(float bunPrice, Float ingredientPrice, Float secondIngredientPrice, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.secondIngredientPrice = secondIngredientPrice;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][]{
                {50f, null, null, 100f},
                {50f, 70f, null, 170f},
                {50f, 70f, 30f, 200f},
        };
    }

    @Mock
    private Bun mockedBun;

    @Mock
    private Ingredient mockedIngredient;

    @Mock
    private Ingredient mockedSecondIngredient;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test

    public void getPriceParameterizedTest() {
        Burger burger = new Burger();
        burger.setBuns(mockedBun);
        Mockito.when(mockedBun.getPrice()).thenReturn(bunPrice);
        if (ingredientPrice != null) {
            burger.addIngredient(mockedIngredient);
            Mockito.when(mockedIngredient.getPrice()).thenReturn(ingredientPrice);
        }
        if (secondIngredientPrice != null) {
            burger.addIngredient(mockedSecondIngredient);
            Mockito.when(mockedSecondIngredient.getPrice()).thenReturn(secondIngredientPrice);
        }
        float actualPrice = burger.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0.01f);
    }
}