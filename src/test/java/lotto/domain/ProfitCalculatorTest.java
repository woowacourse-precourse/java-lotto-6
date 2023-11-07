package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ProfitCalculatorTest {

    @Test
    @DisplayName("로또 총 수익금 계산")
    void calculateProfit() {
        //given
        List<LottoRank> lottoRanks = new ArrayList<>(Arrays.asList(LottoRank.FIFTH_RANK, LottoRank.FORTH_RANK));
        LottoResult lottoResult = new LottoResult(lottoRanks);

        //when
        int result = ProfitCalculator.calculateProfit(lottoResult);

        //then
        assertThat(result).isEqualTo(55000);
    }

    @ParameterizedTest
    @CsvSource({"10000,5000,200", "10000,1000,1000", "5000,8000,62.5"})
    @DisplayName("로또 수익률 계산")
    void calculateProfitMargin(int profit, int amount, double expected) {
        //given

        //when
        double result = ProfitCalculator.calculateProfitMargin(profit, amount);

        //then
        assertThat(result).isEqualTo(expected);
    }
}