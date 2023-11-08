package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.lotto.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    @DisplayName("원하는 개수만큼 로또가 생성되는지 테스트")
    @Test
    void createLottos() {
        int lottoAmount = 5;

        Lottos lottos = Lottos.createLottos(lottoAmount);
        int createdLottoAmount = lottos.getLottoAmount();

        assertThat(createdLottoAmount).isEqualTo(lottoAmount);
    }
}