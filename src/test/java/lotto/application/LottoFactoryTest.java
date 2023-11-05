package lotto.application;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {
    private final LottoFactory lottoFactory = new LottoFactory(new RandomNumberGenerator());

    @Test
    void 자동_로또를_생성한다() {
        // when
        Lotto lotto = lottoFactory.createLottoByAuto();

        // then
        assertNotNull(lotto);
    }

    @Test
    void 수동_로또를_생성한다() {
        // when
        Lotto lotto = lottoFactory.createLottoByManual(List.of(1, 2, 3, 4, 5, 6));

        // then
        assertNotNull(lotto);
    }
}