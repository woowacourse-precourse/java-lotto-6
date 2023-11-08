package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {
    @DisplayName("1~45 사이의 6개 숫자로 로또를 생성한다.")
    @Test
    void createLottoInRange() {
        assertTrue(LottoGenerator.generateRandomLotto().getNumbers().
                stream().allMatch(n -> n >= 1 && n <= 45));
    }

    @DisplayName("주어진 개수의 로또를 생성한다.")
    @Test
    void createLottos() {
        assertEquals(6, LottoGenerator.generateLottos(6).size());
    }
}
