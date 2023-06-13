import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunNameTest {

    @Test
    public void getBunNameTest() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);
        String expectedName = "Флюоресцентная булка R2-D3";
        String actualName = bun.getName();
        assertEquals("Название булочки неверно", expectedName, actualName);
    }
}
