package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;

class EarningCalculatorTest {
    @Test
    void 전체_수익_계산() {
        EarningCalculator calculator = new EarningCalculator();
        EnumMap<LottoRank, Integer> lottoResultMap = new EnumMap<>(LottoRank.class);
        lottoResultMap.put(LottoRank.SECOND, 3);
        lottoResultMap.put(LottoRank.THIRD, 2);
        double expect = 30_000_000 * 3 + 1_500_000 * 2;


        double totalEarnings = calculator.calculateTotalEarnings(lottoResultMap);
        Assertions.assertThat(expect).isEqualTo(totalEarnings);
    }


    @Test
    void 수익률_계산() {
        EarningCalculator calculator = new EarningCalculator();
        EnumMap<LottoRank, Integer> lottoResultMap = new EnumMap<>(LottoRank.class);
        lottoResultMap.put(LottoRank.FIFTH, 30);
        int purchaseAmount = 3000;

        double earningRate = calculator.getEarningRate(lottoResultMap, purchaseAmount);
        Assertions.assertThat(earningRate).isEqualTo(5);
    }


}