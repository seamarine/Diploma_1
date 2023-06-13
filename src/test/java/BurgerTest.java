import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Database dataBase = new Database();
    private final int allBurgerIngredients = dataBase.availableIngredients().size();
    private Burger burger;
    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredientFilling;

    @Before
    public void startUp() {

        burger = new Burger();
        MockitoAnnotations.openMocks(this);
        Mockito.when(mockBun.getPrice()).thenReturn(988F);
        Mockito.when(mockBun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        Mockito.when(mockIngredientFilling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(mockIngredientFilling.getName()).thenReturn("sausage");
        Mockito.when(mockIngredientFilling.getPrice()).thenReturn(300F);
    }


    @Test
    public void addBurgerIngredientTest() {

        for (int i = 0; i < allBurgerIngredients; i++) {
            burger.addIngredient(dataBase.availableIngredients().get(i));
        }
        int actualCount = burger.ingredients.size();

        assertEquals("Ингридиенты не были добавлены", allBurgerIngredients, actualCount);

    }

    @Test
    public void removeBurgerIngredientTest() {

        for (int i = 0; i < allBurgerIngredients; i++) {
            burger.addIngredient(dataBase.availableIngredients().get(i));
        }
        burger.removeIngredient(allBurgerIngredients - 1);
        int actualCount = burger.ingredients.size();

        assertEquals("Ингредиент не был удален", allBurgerIngredients - 1, actualCount);
    }

    @Test
    public void moveBurgerIngredientTest() {

        for (int i = 0; i < allBurgerIngredients; i++) {
            burger.addIngredient(dataBase.availableIngredients().get(i));
        }
        Ingredient ingredient = burger.ingredients.get(allBurgerIngredients - 1);
        burger.moveIngredient(allBurgerIngredients - 1, 0);

        assertEquals("Ингредиент не был перемещен", burger.ingredients.get(0), ingredient);
    }

    @Test
    public void getBurgerPriceTest() {

        final float bunPrice = 988;
        final int bunCount = 2;

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredientFilling);

        float actualPrice = burger.getPrice();
        float expectedPrice = (bunCount * bunPrice) + mockIngredientFilling.getPrice();

        assertEquals("Стоимость бургера подсчитана некорректно", expectedPrice, actualPrice, 0);
    }

    @Test
    public void getReceiptTest() {

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredientFilling);
        String ingredient = mockIngredientFilling.getName();

        assertTrue(
                "В рецепте указаны некорректные данные",
                burger.getReceipt().contains("Флюоресцентная булка R2-D3")
                        &&
                        burger.getReceipt().contains(ingredient)

        );

    }
}
