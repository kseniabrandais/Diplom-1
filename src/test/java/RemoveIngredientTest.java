import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)

public class RemoveIngredientTest {

    private Burger burger;

    @Mock
    private Ingredient mockedFirstIngredient;

    @Mock
    private Ingredient mockedSecondIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
        burger.addIngredient(mockedFirstIngredient);
        burger.addIngredient(mockedSecondIngredient);
    }

    @Test

    public void removeIngredientAndCheckIngredientsSizeIsLowerTest() {
        burger.removeIngredient(1);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test

    public void removeIngredientAndCheckItRemovesCorrectItemTest() {
        burger.removeIngredient(1);
        Assert.assertFalse(burger.ingredients.contains(mockedSecondIngredient));
    }

    @Test

    public void removeIngredientAndCheckIndexOrderIsUpdatedTest() {
        burger.removeIngredient(1);
        Assert.assertEquals(mockedFirstIngredient, burger.ingredients.get(0));
    }

    @Test

    public void removeAllIngredientsAndCheckIngredientsListIsEmpty() {
        burger.removeIngredient(0);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }
}