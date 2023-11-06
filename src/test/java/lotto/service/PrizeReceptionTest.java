package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottosManager;
import lotto.domain.PrizeReception;
import lotto.domain.wrapper.LottoNumber;
import lotto.domain.wrapper.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeReceptionTest {

    @DisplayName("구입 금액과 당첨 금액의 비율로 수익률을 계산한다.")
    @Test
    void getProfitRate() {
        // given
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        LottoNumber bonusNumber = new LottoNumber(7);
        PrizeChecker prizeChecker = new PrizeChecker(winningLotto, bonusNumber);
        LottosManager lottosManager = new LottosManager(List.of(
                new Lotto(List.of(1,2,3,4,7,8)),
                new Lotto(List.of(1,2,3,7,8,9))
        ));
        PrizeReception prizeReception = lottosManager.getPrizeReception(prizeChecker);
        PurchaseAmount purchaseAmount = new PurchaseAmount(2000);
        double expectedProfitRate = (55000 / (double) 2000) * 100;
        // when
        double profitRate = prizeReception.getProfitRate(purchaseAmount);
        // then
        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}