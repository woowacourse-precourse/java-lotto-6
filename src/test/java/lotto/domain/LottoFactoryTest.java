package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoFactoryTest {

    @Test
    void 구매횟수를_입력하면_개수만큼_Lotto생성() {
        Lottos lottos = LottoFactory.createLottos(8);
        assertThat(lottos.getLottos().size()).isEqualTo(8);
    }
}