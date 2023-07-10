import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunPriceValidParameterizedTest {

    private final String name;
    private final float price;
    private final float expectedPrice;

    public BunPriceValidParameterizedTest(String name, float price, float expectedPrice) {
        this.name = name;
        this.price = price;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D312", 988, 988},
                {"Краторная булка N-200i", 1255, 1255}
        };
    }

    @Test
    public void getBunCorrectPriceTest() {
        Bun bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        assertEquals("Стоимость булочки неверна", expectedPrice, actualPrice, 0);
    }

}
