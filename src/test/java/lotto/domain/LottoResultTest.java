package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultTest {

    @DisplayName("주어진 결과에 대한 통계를 정확히 출력하는지 확인합니다.")
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentsProvider")
    void getStatistics(
            String testName,
            int fifthPrizeCount,
            int fourthPrizeCount,
            int thirdPrizeCount,
            int secondPrizeCount,
            int winPrizeCount
    ) {
        Map<LottoPrizes, Integer> expectedPrizes = Map.of(
                LottoPrizes.THREE_NUMBERS_MATCHED, fifthPrizeCount,
                LottoPrizes.FOUR_NUMBERS_MATCHED, fourthPrizeCount,
                LottoPrizes.FIVE_NUMBER_MATCHED, thirdPrizeCount,
                LottoPrizes.FIVE_NUMBER_AND_BONUS_MATCHED, secondPrizeCount,
                LottoPrizes.SIX_NUMBER_MATCHED, winPrizeCount
        );
        LottoResult lottoResult = new LottoResult(expectedPrizes);

        String expectedMessage = String.format("""
                        3개 일치 (5,000원) - %d개
                        4개 일치 (50,000원) - %d개
                        5개 일치 (1,500,000원) - %d개
                        5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                        6개 일치 (2,000,000,000원) - %d개""",
                fifthPrizeCount, fourthPrizeCount, thirdPrizeCount,
                secondPrizeCount, winPrizeCount);

        assertThat(lottoResult.getStatistics()).isEqualTo(expectedMessage);
    }

    @DisplayName("로또 당첨금을 정확하게 얻어내는지 확인합니다.")
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentsProvider")
    void getTotalRevenue(
            String testName,
            int fifthPrizeCount,
            int fourthPrizeCount,
            int thirdPrizeCount,
            int secondPrizeCount,
            int winPrizeCount,
            BigDecimal expectedWinningAmount
    ) {
        Map<LottoPrizes, Integer> expectedPrizes = Map.of(
                LottoPrizes.THREE_NUMBERS_MATCHED, fifthPrizeCount,
                LottoPrizes.FOUR_NUMBERS_MATCHED, fourthPrizeCount,
                LottoPrizes.FIVE_NUMBER_MATCHED, thirdPrizeCount,
                LottoPrizes.FIVE_NUMBER_AND_BONUS_MATCHED, secondPrizeCount,
                LottoPrizes.SIX_NUMBER_MATCHED, winPrizeCount
        );
        LottoResult lottoResult = new LottoResult(expectedPrizes);

        assertThat(lottoResult.getTotalRevenue()).isEqualTo(expectedWinningAmount);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments("전체 로또 중 하나만 5등인 경우", 1, 0, 0, 0, 0, new BigDecimal("5000")),
                arguments("전체 로또 중 하나만 4등인 경우", 0, 1, 0, 0, 0, new BigDecimal("50000")),
                arguments("전체 로또 중 하나만 3등인 경우", 0, 0, 1, 0, 0, new BigDecimal("1500000")),
                arguments("전체 로또 중 하나만 2등인 경우", 0, 0, 0, 1, 0, new BigDecimal("30000000")),
                arguments("전체 로또 중 하나만 1등인 경우", 0, 0, 0, 0, 1, new BigDecimal("2000000000")),
                arguments("1,2,3,4,5등 결과를 모두 가지는 경우", 1, 1, 1, 1, 1, new BigDecimal("2031555000"))
        );
    }
}