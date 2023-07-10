import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertNotEquals;

@RunWith(Parameterized.class)
public class BunPriceNotValidParameterizedTest {
    private final String name;
    private final float price;
    private final float expectedPrice;

    public BunPriceNotValidParameterizedTest(String name, float price, float expectedPrice) {
        this.name = name;
        this.price = price;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Краторная булка N-200i", 1234567, 1255},
                {"Флюоресцентная булка R2-D312", 5.5f, 988}
        };
    }

    @Test
    public void getBunIncorrectPriceTest() {
        Bun bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        assertNotEquals("Стоимость булочки неверна", expectedPrice, actualPrice, 0);
    }
}
