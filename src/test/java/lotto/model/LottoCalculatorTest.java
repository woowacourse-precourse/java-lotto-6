package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCalculatorTest {

    @DisplayName("등수별 개수 계산")
    @Test
    void createCalculateRank() {
        LottoCalculator lottoCalculator = new LottoCalculator(Arrays.asList(1, 2, 3, 0, 0));
        List<Integer> ranks = lottoCalculator.calculateRank();
        assertThat(ranks).isEqualTo(Arrays.asList(0, 0, 0, 0, 1));
    }

    @DisplayName("수익률 계산")
    @Test
    void createCalculateReturnRate() {
        LottoCalculator lottoCalculator = new LottoCalculator(Arrays.asList(1, 2, 3, 0, 0));
        lottoCalculator.calculateRank();
        double returnRate = lottoCalculator.calculateReturnRate(8000);
        assertThat(returnRate).isEqualTo(62.5);
    }


}