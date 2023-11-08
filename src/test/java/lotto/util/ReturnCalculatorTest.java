package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.PrizeType;
import lotto.domain.WinningStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReturnCalculatorTest {
    WinningStatus winningStatus;

    @BeforeEach
    void init() {
        winningStatus = new WinningStatus();
    }

    @Test
    @DisplayName("수익률 계산")
    void 수익률_계산() {
        //given
        winningStatus.add(PrizeType.MATCH3);

        double returns = PrizeType.MATCH3.getPrize();
        double returnOfRate = roundFrom2Digit(returns / 1000 * 100);

        //then
        assertThat(ReturnCalculator.calculate(winningStatus, 1)).isEqualTo(returnOfRate);
    }

    @Test
    @DisplayName("수익률 계산2")
    void 수익률_계산2() {
        //given
        winningStatus.add(PrizeType.MATCH3);
        winningStatus.add(PrizeType.MATCH5);
        winningStatus.add(PrizeType.MATCH6);

        double returns = PrizeType.MATCH3.getPrize() + PrizeType.MATCH5.getPrize() + PrizeType.MATCH6.getPrize();
        double returnOfRate = roundFrom2Digit(returns / 3000 * 100);

        //then
        assertThat(ReturnCalculator.calculate(winningStatus, 3)).isEqualTo(returnOfRate);
    }

    private double roundFrom2Digit(double rateOfReturn) {
        rateOfReturn *= 10;
        rateOfReturn = Math.round(rateOfReturn);

        return rateOfReturn / 10;
    }

    @Test
    @DisplayName("둘째자리 반올림")
    void 둘째_자리_반올림() {
        //given
        winningStatus.add(PrizeType.MATCH3);

        double returns = PrizeType.MATCH3.getPrize();
        double returnOfRate = roundFrom2Digit(returns / 1000 * 100);

        //then
        assertThat(ReturnCalculator.calculate(winningStatus, 1)).isEqualTo(returnOfRate);
    }
}