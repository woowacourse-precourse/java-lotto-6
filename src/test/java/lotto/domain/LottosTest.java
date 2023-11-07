package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.amount.TotalAmount;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoPrize;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Lottos 클래스")
class LottosTest {

    @DisplayName("로또의 누적 당첨 금액을 계산한다.")
    @Test
    void accumulateAllLottosPrize() {
        Lottos lottos = Lottos.from(
            List.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.from(List.of(1, 2, 3, 4, 5, 6)))
        );

        WinningLotto winningLotto = WinningLotto.of(
            List.of(1, 2, 3, 7, 8, 9),
            BonusNumber.from(10)
        );

        TotalAmount totalPrize = lottos.accumulatePrize(winningLotto);

        long expectedPrizeForOneLotto = LottoPrize.findLottoPrize(3, false).getPrizeAmount();
        long expectedTotalPrize = expectedPrizeForOneLotto * lottos.count();

        assertThat(totalPrize.getAmount()).isEqualTo(expectedTotalPrize);
    }

}