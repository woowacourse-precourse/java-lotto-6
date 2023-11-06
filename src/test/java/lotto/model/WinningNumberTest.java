package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {

    @Test
    public void testObjectCreation() {
        WinningNumber winningNumber1 = new WinningNumber("1,2,3,4,5,6");
        WinningNumber winningNumber2 = new WinningNumber("1,2,3,4,5,6");
        Assertions.assertEquals(winningNumber1, winningNumber2);
    }

}
