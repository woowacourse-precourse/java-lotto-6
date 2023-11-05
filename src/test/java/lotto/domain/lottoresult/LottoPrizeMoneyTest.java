package lotto.domain.lottoresult;

import static lotto.domain.lottoresult.LottoPrizeMoney.makeZeroLottoPrizeMoney;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPrizeMoneyTest {

    @DisplayName("3등, 5등 당첨을 업데이트하면, 누적 상금이 1,505,000 이 된다.")
    @Test
    void lottoPrizeMoneyTest_1() {
        LottoPrizeMoney lottoPrizeMoney = makeZeroLottoPrizeMoney();
        lottoPrizeMoney = lottoPrizeMoney.updateLottoPrizeMoney(LottoResult.THIRD);
        lottoPrizeMoney = lottoPrizeMoney.updateLottoPrizeMoney(LottoResult.FIFTH);
        Assertions.assertThat(lottoPrizeMoney.getLottoPrizeMoney()).isEqualTo(1505000);
    }
}
