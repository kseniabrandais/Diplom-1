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

public class MoveIngredientTest {

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

    public void moveIngredientAndItShiftsForwardTest() {
        burger.moveIngredient(0, 1);
        Assert.assertEquals(mockedFirstIngredient, burger.ingredients.get(1));
    }

    @Test

    public void moveIngredientAndItShiftsBackwardTest() {
        burger.moveIngredient(1, 0);
        Assert.assertEquals(mockedSecondIngredient, burger.ingredients.get(0));
    }

    @Test

    public void moveIngredientAndSizeRemainsSameTest() {
        int originalSize = burger.ingredients.size();
        burger.moveIngredient(1, 0);
        Assert.assertEquals(originalSize, burger.ingredients.size());
    }
}
