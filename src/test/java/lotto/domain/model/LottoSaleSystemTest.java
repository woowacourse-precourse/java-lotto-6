package lotto.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoSaleSystemTest {

    LottoSaleSystem lottoSaleSystem = new LottoSaleSystem();
    LottoWinnerSystem lottoWinnerSystem = new LottoWinnerSystem();


    @DisplayName("구입 금액에 따른 로또 구매 개수를 정상적으로 반환해야 한다.")
    @Test
    void 구매개수_반환() {
        // given
        String purchaseMoney = "8000";

        // when
        lottoSaleSystem.isValidMoney(purchaseMoney);

        // then
        assertThat(lottoSaleSystem.getPurchaseCount()).isEqualTo(8);
    }

    @DisplayName("구입 금액과 당첨 금액에 따른 수익률이 정상적으로 계산되어야 한다.")
    @Test
    void 수익률_계산() {
        // given
        String purchaseMoney = "1000";
        List<Integer> compareLotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winNumber = new ArrayList<>(List.of(1, 2, 3, 7, 8, 9));
        List<Integer> bonusNumber = new ArrayList<>(List.of(13));

        // when
        lottoSaleSystem.isValidMoney(purchaseMoney);
        int matchCount = lottoWinnerSystem.getMatchNumberCount(compareLotto, winNumber);
        if (matchCount >= 3) {
            lottoWinnerSystem.compareOneLotto(compareLotto, bonusNumber, matchCount);
        }

        // then
        assertThat(lottoSaleSystem.calculateProfit()).isEqualTo(500);
    }
}