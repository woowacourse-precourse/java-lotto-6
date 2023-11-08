package lotto.domain.number;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomNumberStrategyTest {
    @DisplayName("로또 입력 값이 null일 경우 예외가 발생한다.")
    @Test
    void testValidRandomNumberGenerate() {
        RandomNumberStrategy randomNumberStrategy = new RandomNumberStrategy();
        Lotto lotto = randomNumberStrategy.generateNumber();

        assertEquals(6, lotto.getNumbers().size());
    }
}
