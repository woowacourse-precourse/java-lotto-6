package lotto.domain.lottoresult;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.player.Profit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPrizeMoneyTest {

    // 테스트 GivenCondition 을 위한 함수. 5등 당첨 내역을 업데이트한 LottoPrizeMoney 를 만든다.
    public static LottoPrizeMoney getLottoPrizeMoneyWithFifthResult() {
        LottoPrizeMoney lottoPrizeMoney = LottoPrizeMoney.makeZeroLottoPrizeMoney();
        return lottoPrizeMoney.updateLottoPrizeMoney(LottoResult.FIFTH);
    }

    @DisplayName("5,000원 당첨 결과에 10,000원 사용 수익률을 계산하면 50.0이 나온다.")
    @Test
    void lottoPrizeMoneyTest_1() {
        LottoPrizeMoney lottoPrizeMoney = getLottoPrizeMoneyWithFifthResult();

        Profit profit = lottoPrizeMoney.calculateProfit(10000);
        assertThat(profit.getProfit()).isEqualTo(50.0);
    }
}
