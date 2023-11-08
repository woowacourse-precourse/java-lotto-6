package lotto.domain.number;

import lotto.domain.Lotto;
import lotto.domain.number.RandomNumberStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomNumberStrategyTest {

    @Test
    void generateNumber_ShouldReturnLottoWith6Numbers() {
        RandomNumberStrategy randomNumberStrategy = new RandomNumberStrategy();
        Lotto lotto = randomNumberStrategy.generateNumber();

        // 반환된 로또 번호 리스트는 6개의 숫자를 가져야 합니다.
        assertEquals(6, lotto.getNumbers().size());
    }
}
