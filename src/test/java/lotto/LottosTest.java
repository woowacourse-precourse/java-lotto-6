package lotto;

import static org.junit.jupiter.api.Assertions.*;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    @Test
    @DisplayName("로또 생성 테스트")
    void createLottosCountTest() {
        int count = 10;
        Lottos lottos = Lottos.generateLottos(count);
        assertEquals(count, lottos.getLottos().size());
    }

    @Test
    @DisplayName("로또 범위 테스트")
    void generateLottosNumberRange() {
        int count = 1000;
        Lottos lottos = Lottos.generateLottos(count);

        for (Lotto lotto : lottos.getLottos()) {
            assertTrue(lotto.getNumbers().stream().allMatch(number -> number >= 1 && number <= 45));
        }
    }

    @Test
    @DisplayName("고유한 로또 숫자 생성 테스트")
    void uniqueLottoSNumberTest() {
        int count = 1000;
        Lottos lottos = Lottos.generateLottos(count);
        for (Lotto lotto : lottos.getLottos()) {
            assertEquals(lotto.getNumbers().size(), lotto.getNumbers().stream().distinct().count());
        }
    }
}
