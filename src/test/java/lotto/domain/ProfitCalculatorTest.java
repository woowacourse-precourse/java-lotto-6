package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.repository.LottoResultRepository;
import lotto.domain.repository.PurchaseAmountRepository;
import lotto.util.enumerator.LottoRank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProfitCalculatorTest {
    private static final double EXPECTED_PROFIT_RATE = 62.5;

    @AfterEach
    void cleanUp() {
        LottoResultRepository.clear();
        PurchaseAmountRepository.clear();
    }

    @DisplayName("수익을 계산하고, 최종 수익률을 반환한다.")
    @ParameterizedTest
    @MethodSource("generateLottoResult")
    void calculateProfitAndReturnTotalProfitRate(List<LottoRank> ranks, long purchase) {
        // given
        LottoResult lottoResult = new LottoResult(ranks);
        LottoResultRepository.add(lottoResult);
        PurchaseAmount purchaseAmount = new PurchaseAmount(purchase);
        PurchaseAmountRepository.add(purchaseAmount);

        // when
        ProfitCalculator profitCalculator = new ProfitCalculator();
        double totalProfitRate = profitCalculator.calculateProfit();

        // then
        Assertions.assertEquals(EXPECTED_PROFIT_RATE, totalProfitRate);
    }

    static Stream<Arguments> generateLottoResult() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(LottoRank.FIFTH, LottoRank.NONE, LottoRank.NONE, LottoRank.NONE, LottoRank.NONE), 8000L)
                );
    }
}