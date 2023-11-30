package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LottoFactoryTest {
    @DisplayName("로또 카운트만큼 lottos 생성되는지 테스트.")
    @Test
    void createLottosTest() {
        int lottoCount = 5;
        Lottos lottos = LottoFactory.createLottos(lottoCount);

        assertNotNull(lottos);
        assertEquals(lottoCount, lottos.getLottos().size());
    }
}
