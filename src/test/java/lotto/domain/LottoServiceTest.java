package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class LottoServiceTest {


    @Test
    @DisplayName("구입 금액을 받아서 구매 개수를 반환한다")
    void getPurchaseAmountReturnLottoCount() {
        LottoService lottoService = new LottoService();

        int purchaseAmount = 8000;
        int lottoCount = lottoService.calculateLottoCount(purchaseAmount);

        Assertions.assertThat(lottoCount).isEqualTo(8);
    }

    @Test
    @DisplayName("당첨 결과를 가져와서 총 당첨 금액을 반환한다")
    void calculateTotalPrize() {
        LottoService lottoService = new LottoService();

        Map<LottoRank, Integer> winningResults = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            winningResults.put(lottoRank, 1);
        }

        long expectedTotalPrize = 0;
        for (LottoRank lottoRank : LottoRank.values()) {
            expectedTotalPrize += lottoRank.getPrize();
        }

        Assertions.assertThat(lottoService.calculateTotalPrize(winningResults))
                .isEqualTo(expectedTotalPrize);
    }

}