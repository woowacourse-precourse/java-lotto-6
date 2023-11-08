package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.RandomLottoGenerator;
import lotto.domain.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

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
        assertThat(lottos.size()).isEqualTo(2);
        assertThat(lottos).hasSize(2);
    }

    @Test
    void 로또_결과() {
        // given
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        List<Lotto> purchasedLottos = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));

        // when
        Map<Rank, Long> results = lottoService.calculateResults(winningLotto, purchasedLottos, bonusNumber);

        // then
        assertThat(results).containsEntry(Rank.FIRST, 1L);
        assertThat(results).containsEntry(Rank.SECOND, 1L);
    }
}