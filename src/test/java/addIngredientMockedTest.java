import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)

public class addIngredientMockedTest {

    private Burger testBurger;

    @Before
    public void setUp() {
        testBurger = new Burger();
    }

    @Mock
    private Ingredient mockedIngredient;
    @Mock
    private IngredientType mockedIngredientType;

    @Test

    public void burgerAddIngredientNotNullTest() {
        testBurger.addIngredient(mockedIngredient);
        Assert.assertNotNull(testBurger.ingredients);
    }

    @Test

    public void burgerAddIngredientContainsActualIngredientTest() {
        testBurger.addIngredient(mockedIngredient);
        Assert.assertTrue(testBurger.ingredients.contains(mockedIngredient));
    }

    @Test

    public void burgerAddIngredientIncreasesListSize() {
        testBurger.addIngredient(mockedIngredient);
        Assert.assertEquals(1, testBurger.ingredients.size());
    }

    @Test

    public void burgerAddIngredientSavesCorrectTypeTest() {
        Mockito.when(mockedIngredient.getType()).thenReturn(mockedIngredientType);
        testBurger.addIngredient(mockedIngredient);
        Assert.assertEquals(mockedIngredientType, testBurger.ingredients.get(0).getType());
    }

    @Test

    public void burgerAddIngredientSavesCorrectNameTest() {
        Mockito.when(mockedIngredient.getName()).thenReturn("курица");
        testBurger.addIngredient(mockedIngredient);
        Assert.assertEquals("курица", testBurger.ingredients.get(0).getName());
    }

    @Test

    public void burgerAddIngredientSavesCorrectPriceTest() {
        Mockito.when(mockedIngredient.getPrice()).thenReturn(50f);
        testBurger.addIngredient(mockedIngredient);
        Assert.assertEquals(50f, testBurger.ingredients.get(0).getPrice(), 0.01f);
    }
}
