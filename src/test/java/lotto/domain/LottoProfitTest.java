package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import lotto.domain.strategy.LottoNumberGenerator;
import lotto.domain.strategy.RandomLottoNumberGenerator;
import lotto.vo.TotalAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoProfitTest {
    static Stream<Arguments> provideLottoData() {
        return Stream.of(
                arguments(LottoRank.FIRST, 1, (double)LottoRank.FIRST.getReward() / 100000 * 100), // 1등 당첨인 경우
                arguments(LottoRank.FIFTH, 1, (double)LottoRank.FIFTH.getReward() / 100000 * 100), // 5등 당첨인 경우
                arguments(null, 0, 0.0) // 당첨되지 않은 경우
        );
    }

    @ParameterizedTest
    @MethodSource("provideLottoData")
    @DisplayName("총 수익률 계산 테스트")
    void testCalculateProfitRate(LottoRank lottoRank, int count, double expectedProfitRate) {
        // Given
        LottoNumberGenerator lottoNumberGenerator = new RandomLottoNumberGenerator();
        LottoPurchase lottoPurchase = LottoPurchase.from(TotalAmount.from(100000), lottoNumberGenerator);

        RankResult rankResult = RankResult.create();
        if (lottoRank != null) {
            for (int i = 0; i < count; i++) {
                rankResult.add(lottoRank); // 테스트 데이터에 맞게 당첨 등수 추가
            }
        }
        LottoProfit lottoProfit = LottoProfit.of(lottoPurchase, rankResult);

        // When
        double profitRate = lottoProfit.calculateProfitRate();

        // Then
        assertEquals(expectedProfitRate, profitRate, "계산된 수익률이 예상치와 일치해야 한다.");
    }
}
