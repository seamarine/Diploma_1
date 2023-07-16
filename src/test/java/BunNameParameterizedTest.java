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
                {"Флюоресцентная булка-312", 988, "Флюоресцентная булка-312"},
                {"Краторная булка N200i", 1255, "Краторная булка N200i"},
                {"Очень длинное наименование английской булочки", 1255, "Очень длинное наименование английской булочки"},
                {"", 500, ""},
                {null, 0, null},
                {"بون", 500, "بون"}
        };
    }


    @Test
    public void getBunNameTest() {
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        assertEquals("Название булочки неверно", expectedName, actualName);
    }
}
