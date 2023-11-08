package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.RandomLottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoServiceTest {

    private RandomLottoGenerator lottoGenerator;
    private LottoService lottoService;

    @BeforeEach
    void beforeEach() {
        lottoGenerator = new RandomLottoGenerator();
        lottoService = new LottoService(lottoGenerator);
    }

    @Test
    void 로또_구매() {
        // given
        int purchaseAmount = 2000;

        // when
        List<Lotto> lottos = lottoService.buyLotto(purchaseAmount);

        // then
        Assertions.assertThat(lottos.size()).isEqualTo(2);
    }
}