import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunNameParameterizedTest {
    private final String name;
    private final float price;
    private final String expectedName;

    public BunNameParameterizedTest(String name, float price, String expectedName) {
        this.name = name;
        this.price = price;
        this.expectedName = expectedName;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D312", 988, "Флюоресцентная булка R2-D312"},
                {"Краторная булка N-200i", 1255, "Краторная булка N-200i"}
        };
    }


    @Test
    public void getBunNameTest() {
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        assertEquals("Название булочки неверно", expectedName, actualName);
    }
}
