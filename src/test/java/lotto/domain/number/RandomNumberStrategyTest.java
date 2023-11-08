package lotto.domain.number;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomNumberStrategyTest {
    @Test
    void generateNumber_ShouldReturnLottoWith6Numbers() {
        RandomNumberStrategy randomNumberStrategy = new RandomNumberStrategy();
        Lotto lotto = randomNumberStrategy.generateNumber();

        assertEquals(6, lotto.getNumbers().size());
    }
}
