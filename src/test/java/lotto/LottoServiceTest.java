package lotto;

import consts.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoServiceTest {
    @Test
    @DisplayName("로또 6000원 구매시 6개의 로또 구매")
    void 로또_6000원_구매시_6개의_로또_구매() {
        LottoService lottoService = LottoService.create(6000);
        lottoService.purchaseLotto();

        assertThat(lottoService.getLottos().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 결과에 대한 수익률")
    void 로또_결과에_대한_수익률() {
        LottoService lottoService = LottoService.create(1000);
        Map<Rank, Integer> ranks = Map.of(Rank.FOURTH, 1);

        assertThat(lottoService.calculateProfitRate(ranks)).isEqualTo(5000);
    }
}
