import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunPriceTest {

    @Test
    public void getBunPriceTest() {
        Bun bun = new Bun("Краторная булка N-200i", 1255);
        int expectedPrice = 1255;
        float actualPrice = bun.getPrice();
        assertEquals("Стоимость булочки неверна", expectedPrice, actualPrice, 0);
    }
}
