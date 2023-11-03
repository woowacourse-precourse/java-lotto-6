package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Lotto winnerLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    Lotto userLotto = new Lotto(Arrays.asList(5, 6, 7, 8, 9, 10));
    List<Lotto> userLottos = new ArrayList<>(Arrays.asList(userLotto));

    @DisplayName("같은 숫자가 몇 개 있는지 확인하는 테스트")
    @Test
    void countMatchingNumberTest() {
        Calculator calculator = new Calculator(winnerLotto, userLottos);
        int expected = 2;
        int actual = calculator.countMatchingNumber(winnerLotto, userLottos.get(0));
        assertEquals(expected, actual);
    }
}
