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
import praktikum.IngredientType;

@RunWith(Parameterized.class)

public class GetReceiptParameterizedTest {

    private final String bunName;
    private final float bunPrice;

    private final String firstIngredient;
    private final IngredientType firstIngredientType;
    private final Float firstIngredientPrice;

    private final String secondIngredient;
    private final IngredientType secondIngredientType;
    private final Float secondIngredientPrice;

    private final String expectedReceipt;

    public GetReceiptParameterizedTest(String bunName, float bunPrice, String firstIngredient, IngredientType firstIngredientType, Float firstIngredientPrice, String secondIngredient, IngredientType secondIngredientType, Float secondIngredientPrice, String expectedReceipt) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.firstIngredient = firstIngredient;
        this.firstIngredientType = firstIngredientType;
        this.firstIngredientPrice = firstIngredientPrice;
        this.secondIngredient = secondIngredient;
        this.secondIngredientType = secondIngredientType;
        this.secondIngredientPrice = secondIngredientPrice;
        this.expectedReceipt = expectedReceipt;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}, {2}")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"Цельнозерновая", 50f, null, null, null, null, null, null, "(==== Цельнозерновая ====)\n" + "(==== Цельнозерновая ====)\n" + "\nPrice: 100,000000\n"},
                {"Цельнозерновая", 50f, "курица", IngredientType.FILLING, 70f, null, null, null, "(==== Цельнозерновая ====)\n" + "= filling курица =\n" + "(==== Цельнозерновая ====)\n" + "\nPrice: 170,000000\n"},
                {"Цельнозерновая", 50f, "курица", IngredientType.FILLING, 70f, "горчичный", IngredientType.SAUCE, 30f, "(==== Цельнозерновая ====)\n" + "= filling курица =\n" + "= sauce горчичный =\n" + "(==== Цельнозерновая ====)\n" + "\nPrice: 200,000000\n"},
        };
    }

    @Mock
    private Bun mockedBun;

    @Mock
    private Ingredient mockedFirstIngredient;

    @Mock
    private Ingredient mockedSecondIngredient;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test

    public void getReceiptParameterizedTest() {
        Burger burger = new Burger();
        burger.setBuns(mockedBun);
        Mockito.when(mockedBun.getName()).thenReturn(bunName);
        Mockito.when(mockedBun.getPrice()).thenReturn(bunPrice);
        if (firstIngredient != null) {
            burger.addIngredient(mockedFirstIngredient);
            Mockito.when(mockedFirstIngredient.getName()).thenReturn(firstIngredient);
            Mockito.when(mockedFirstIngredient.getType()).thenReturn(firstIngredientType);
            Mockito.when(mockedFirstIngredient.getPrice()).thenReturn(firstIngredientPrice);
        }
        if (secondIngredient != null) {
            burger.addIngredient(mockedSecondIngredient);
            Mockito.when(mockedSecondIngredient.getName()).thenReturn(secondIngredient);
            Mockito.when(mockedSecondIngredient.getType()).thenReturn(secondIngredientType);
            Mockito.when(mockedSecondIngredient.getPrice()).thenReturn(secondIngredientPrice);
        }
        String actualReceipt = burger.getReceipt();
        Assert.assertEquals(expectedReceipt, actualReceipt);
    }
}
