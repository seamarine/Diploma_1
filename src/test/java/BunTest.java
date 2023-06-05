import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getBunNameTest() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);
        String expectedName = "Флюоресцентная булка R2-D3";
        String actualName = bun.getName();
        assertEquals("Название булочки неверно", expectedName, actualName);
    }

    @Test
    public void getBunPriceTest() {
        Bun bun = new Bun("Краторная булка N-200i", 1255);
        int expectedPrice = 1255;
        float actualPrice = bun.getPrice();
        assertEquals("Стоимость булочки неверна", expectedPrice, actualPrice, 0);
    }
}
