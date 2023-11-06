package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningNumberTest {

    @Test
    public void testObjectCreation() {
        WinningNumbers winningNumber1 = new WinningNumbers(List.of(1,2,3,4,5,6),7);
        WinningNumbers winningNumber2 = new WinningNumbers(List.of(1,2,3,4,5,6),7);
        Assertions.assertEquals(winningNumber1, winningNumber2);
    }

}
