package lotto.service;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;
import lotto.domain.numbergenerator.RandomLottoNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    @DisplayName("구매 금액에 맞는 로또를 수령한다.")
    @Test
    void 구매_금액에_맞는_로또_수령() {
        LottoService lottoService = new LottoService(new RandomLottoNumberGenerator());
        int purchaseAmount = 10000;
        List<Lotto> lottos = lottoService.buyLottos(purchaseAmount);

        assertThat(lottos).hasSize(10);
    }
}