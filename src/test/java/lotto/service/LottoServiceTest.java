package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    @DisplayName("로또 구입 금액 만큼 로또를 생성한다")
    @Test
    void createLottosByLottoPurchaseAmount() {
        final int lottoPurchaseAmount = 5000;
        LottoService lottoService = new LottoService();
        List<Lotto> lottos = lottoService.createLottos(lottoPurchaseAmount);

        final int expectedLottosSize = 5;
        assertThat(lottos.size()).isEqualTo(expectedLottosSize);
    }
}