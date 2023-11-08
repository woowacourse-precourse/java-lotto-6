package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoCalculatorTest {

    LottoCalculator lottoCalculator = new LottoCalculator();

    @DisplayName("로또 번호를 당첨 번호와 비교해 몇 개 맞는지 확인한다.")
    @Test
    void checkContainsWinning() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumber = List.of(1, 8, 3, 2, 45, 10);

        int winningCount = lottoCalculator.checkContainsWinning(winningNumber, lottoNumber);

        assertThat(winningCount)
                .isEqualTo(3);
    }

    @DisplayName("로또 번호 안에 보너스 번호가 존재하는지 확인한다.")
    @Test
    void checkContainsBonus() {
        int bonusNumber = 5;
        List<Integer> lottoNumber = List.of(1, 8, 3, 2, 45, 10);

        int bonusCount = lottoCalculator.checkContainsBonus(bonusNumber, lottoNumber);

        assertThat(bonusCount)
                .isEqualTo(0);
    }

    @DisplayName("총 수익률을 확인한다.")
    @Test
    void calculateRateOfReturn() {
        int seedMoney = 9000;
        List<Integer> resultData = List.of(1, 0, 0, 0, 0);

        double rateOfReturn = lottoCalculator.calculateRateOfReturn(seedMoney, resultData);

        assertThat(rateOfReturn)
                .isEqualTo(55.6);
    }
}