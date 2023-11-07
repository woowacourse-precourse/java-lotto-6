package lotto.unitTest;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

import static lotto.domain.Lottos.generateLottos;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottosTest {

    @Test
    void 생성된_로또_갯수_확인() {
        long lottoCount = 5;
        Lottos purchasedLottos = generateLottos(lottoCount);
        assertEquals(lottoCount, purchasedLottos.count());
    }

    @Test
    void 로또_갯수_0_생성_오류() {
        long lottoCount = 0;
        assertThatThrownBy(() -> generateLottos(lottoCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_갯수_음수_생성_오류() {
        long lottoCount = -1;
        assertThatThrownBy(() -> generateLottos(lottoCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
