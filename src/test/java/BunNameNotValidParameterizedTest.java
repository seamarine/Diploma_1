import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertNotEquals;

@RunWith(Parameterized.class)
public class BunNameNotValidParameterizedTest {
    private final String name;
    private final float price;
    private final String expectedName;

    public BunNameNotValidParameterizedTest(String name, float price, String expectedName) {
        this.name = name;
        this.price = price;
        this.expectedName = expectedName;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {null, 1255, "Краторная булка N-200i"},
                {"Несуществующая булочка", 1255, "Краторная булка N-200i"}
        };
    }

    @Test
    public void getBunNameTest() {
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        assertNotEquals("Название булочки неверно", expectedName, actualName);
    }
}
