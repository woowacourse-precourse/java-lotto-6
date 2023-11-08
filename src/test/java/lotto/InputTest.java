package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import lotto.adapter.UserInputAdapter;
import lotto.port.InputPort;
import org.junit.jupiter.api.Test;

public class InputTest {

    private InputPort userInput = new UserInputAdapter();

    @Test
    public void 구입금액을_입력받는_테스트() {
        System.setIn(new ByteArrayInputStream("10000\n".getBytes()));

        Integer purchaseAmount = userInput.readPurchaseAmount();

        assertEquals(10000, purchaseAmount);
    }

    @Test
    public void 당첨_번호를_입력받는_테스트() {
        System.setIn(new ByteArrayInputStream("1, 2, 3, 4, 5, 6\n".getBytes()));

        List<Integer> drawNumbers = userInput.readDrawNumbers();

        List<Integer> expected = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            expected.add(i);
        }
        assertEquals(expected, drawNumbers);
    }

    @Test
    public void 보너스_번호를_입력받는_테스트() {
        System.setIn(new ByteArrayInputStream("7\n".getBytes()));

        Integer bonusNumber = userInput.readBonusNumber();

        assertEquals(7, bonusNumber);
    }


}
