package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottosTest {
    @Test
    void createLottoTest() {
        Lottos lottos = new Lottos();
        lottos.createLotto();

        List<Lotto> purchasedLottos = lottos.purchasedLottos;

        assertEquals(1, purchasedLottos.size());
        assertEquals(Lottos.NUMBER_QUANTITY, purchasedLottos.get(0).getNumbers().size());
    }
}

