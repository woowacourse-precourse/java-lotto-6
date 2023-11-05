package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.util.ReturnCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReturnCalculatorTest {
    @Test
    @DisplayName("수익률 계산")
    void 수익률_계산() {
        //1000원 내고 5000원 당첨
        WinningStatus winningStatus = new WinningStatus();
        winningStatus.add(PrizeType.MATCH3);

        assertThat(ReturnCalculator.calculate(winningStatus, 1)).isEqualTo((double) 5000 / 1000 * 100);
    }

    @Test
    @DisplayName("둘째자리 반올림")
    void 둘째_자리_반올림() {
        //3000원 내고 5000원 당첨
        WinningStatus winningStatus = new WinningStatus();
        winningStatus.add(PrizeType.MATCH3);

        double expected = ((double) 5000 / 3000) * 100;
        expected *= 10;
        expected = Math.round(expected);
        expected /= 10;

        assertThat(ReturnCalculator.calculate(winningStatus, 3)).isEqualTo(expected);
    }
}