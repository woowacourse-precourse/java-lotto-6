package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.RandomLottoGenerator;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    private RandomLottoGenerator lottoGenerator;
    private LottoService lottoService;

    @BeforeEach
    void beforeEach() {
        lottoGenerator = new RandomLottoGenerator();
        lottoService = new LottoService(lottoGenerator);
    }

    @Test
    void 로또_번호_범위_테스트() {
        // given
        int purchaseAmount = 20000;

        // when
        List<Lotto> lottos = lottoService.buyLotto(purchaseAmount);

        // then
        assertThat(lottos.stream().allMatch(lotto ->
                lotto.getNumbers().stream().allMatch(number -> number >= 1 && number <= 45)
        )).isTrue();
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

    @Test
    void 수익률() {
        // given
        List<Lotto> purchasedLottos = Arrays.asList(new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)),
                new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)),
                new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)),
                new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)),
                new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)),
                new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)),
                new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)),
                new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45))
        );
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        Map<Rank, Long> results = lottoService.calculateResults(winningLotto, purchasedLottos, bonusNumber);

        // when
        double profit = lottoService.calculateProfit(purchasedLottos, results);

        // then
        assertThat(profit).isEqualTo(62.5);
    }
}