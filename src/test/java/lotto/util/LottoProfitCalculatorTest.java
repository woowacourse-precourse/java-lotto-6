package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.LottoRank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoProfitCalculatorTest {

    @DisplayName("소수점 둘째 자리에서 반올림하여 로또 수익률 계산 테스트")
    @ParameterizedTest
    @MethodSource("getLottoRanksAndTotalCost")
    void calculateProfit(List<LottoRank> lottoRanks, int totalCost, BigDecimal expected) {
        // Arrange & Act
        BigDecimal profit = LottoProfitCalculator.calculate(lottoRanks, totalCost);

        // Assert
        Assertions.assertEquals(expected.toPlainString(), profit.toPlainString());
    }

    private static Stream<Arguments> getLottoRanksAndTotalCost() {
        return Stream.of(
           Arguments.of(List.of(LottoRank.FIFTH_PLACE), 7000, new BigDecimal(71.4).setScale(1, RoundingMode.FLOOR)),
            Arguments.of(List.of(LottoRank.FIFTH_PLACE), 1000, new BigDecimal(500)),
            Arguments.of(List.of(LottoRank.FIFTH_PLACE), 8000, new BigDecimal(62.5) .setScale(1, RoundingMode.FLOOR)),
            Arguments.of(List.of(LottoRank.FOURTH_PLACE), 5000, new BigDecimal(1000)),
            Arguments.of(List.of(LottoRank.FIRST_PLACE), 50000, new BigDecimal(4000000))
        );
    }
}