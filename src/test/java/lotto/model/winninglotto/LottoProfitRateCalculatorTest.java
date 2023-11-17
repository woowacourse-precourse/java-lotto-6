package lotto.model.winninglotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import lotto.model.LottoRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoProfitRateCalculatorTest {

    @Test
    @DisplayName("LottoProfitRateCalculator로 수익률을 계산할 수 있다.")
    void calculateLottoProfitRateTest() {
        int count = 10;
        EnumMap<LottoRanking, Integer> lottoResult = new EnumMap<>(LottoRanking.class);
        lottoResult.put(LottoRanking.FOURTH, count);

        double lottoProfitRate = LottoProfitRateCalculator.calculateLottoProfitRate(lottoResult,
            LottoRanking.FOURTH.getWinningAmount());

        assertThat(lottoProfitRate).isEqualTo(count * 100);
    }
}
