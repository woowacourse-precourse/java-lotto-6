package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoStatisticsTest {
    private LottoStatistics lottoStatistics;

    @BeforeEach
    void setUp() {
        lottoStatistics = new LottoStatistics();
    }

    @DisplayName("로또 번호와 당첨 번호를 비교해 몇개의 숫자가 동일한지 계산한다.")
    @Test
    void countMatchingWinningNumbers() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winner = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        int result = lottoStatistics.compareLottoNumbersWithWinnerNumbers(lotto, winner);

        assertThat(result).isEqualTo(5);
    }

    @DisplayName("로또 번호와 보너스 넘버를 비교해 보너스 번호가 있는지 확인한다.")
    @Test
    void checkMatchingBonusNumber() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;
        String result = lottoStatistics.compareLottoNumbersWithBonusNumber(lotto, bonusNumber);
        String answer = "Bonus";

        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("로또 번호와 보너스 넘버를 비교해 보너스 번호가 없는지 확인한다.")
    @Test
    void checkMatchingNoBonusNumber() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        String result = lottoStatistics.compareLottoNumbersWithBonusNumber(lotto, bonusNumber);
        String answer = "NoBonus";

        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculateProfit() {
        double result = lottoStatistics.calculateProfit(5000, 8);
        double answer = 62.5;

        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("당첨 결과를 받으면 합산하고 총 수익률을 계산한다.")
    @Test
    void claculateTotalProfit() {
        Map<String, Integer> summary = new LinkedHashMap<>();
        summary.put("5등", 4);
        summary.put("4등", 2);
        summary.put("3등", 0);
        summary.put("2등", 0);
        summary.put("1등", 0);

        String result = lottoStatistics.calculateTotalProfit(summary, 17);
        String answer = "705.9";

        assertThat(result).isEqualTo(answer);
    }
}