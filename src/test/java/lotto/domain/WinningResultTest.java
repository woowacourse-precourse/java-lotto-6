package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.constant.WinningGrade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

@DisplayName("당첨 결과 도메인에")
class WinningResultTest {

    @DisplayName("우승 단계에 따른 개수 요청시 가진 개수를 반환한다.")
    @Test
    void numOfWinningGrade() {
        // given
        final int expected = 10;
        final WinningGrade firstGrade = WinningGrade.FIRST_GRADE;
        final WinningResult winningResult = new WinningResult(Map.of(firstGrade, expected));

        // when
        final int result = winningResult.numOfWinningGrade(firstGrade);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("수익률 확인 요청시 수익률을 반환한다.")
    @Test
    void calculateProfit() {
        // given
        final WinningGrade winningGrade = WinningGrade.FIRST_GRADE;
        final WinningResult winningResult = new WinningResult(Map.of(winningGrade, 1));
        final PurchaseAmount purchaseAmount = new PurchaseAmount(winningGrade.toPrize());

        // when
        final EarningRate earningRate = winningResult.calculateProfit(purchaseAmount);

        // then
        assertThat(earningRate.toValue())
                .isEqualTo((double) winningGrade.toPrize() / purchaseAmount.toValue() * 100.0);
    }
}
