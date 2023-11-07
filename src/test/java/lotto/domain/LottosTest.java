package lotto.domain;

import lotto.domain.lotto.Lottos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @Test
    void 구매개수에_따른_로또를_생성한다() {
        // Given
        LottoAmount lottoAmount = new LottoAmount(2000);

        // When
        Lottos lottos = Lottos.generateByAmount(lottoAmount);

        // Then
        assertNotNull(lottos);
    }
}