package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Map;
import java.util.stream.Stream;
import lotto.domain.constant.LottoPrizes;
import lotto.domain.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultTest {
    @DisplayName("로또 당첨금을 정확하게 얻어내는지 확인합니다.")
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentsProvider")
    void getTotalRevenue(
            String testName,
            long fifthPrizeCount,
            long fourthPrizeCount,
            long thirdPrizeCount,
            long secondPrizeCount,
            long winPrizeCount,
            Money expectedWinningAmount
    ) {
        Map<LottoPrizes, Long> expectedPrizes = Map.of(
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
                arguments("전체 로또 중 하나만 5등인 경우", 1L, 0L, 0L, 0L, 0L, new Money(5000L)),
                arguments("전체 로또 중 하나만 4등인 경우", 0L, 1L, 0L, 0L, 0L, new Money(50000L)),
                arguments("전체 로또 중 하나만 3등인 경우", 0L, 0L, 1L, 0L, 0L, new Money(1500000L)),
                arguments("전체 로또 중 하나만 2등인 경우", 0L, 0L, 0L, 1L, 0L, new Money(30000000L)),
                arguments("전체 로또 중 하나만 1등인 경우", 0L, 0L, 0L, 0L, 1L, new Money(2000000000L)),
                arguments("1,2,3,4,5등 결과를 모두 가지는 경우", 1L, 1L, 1L, 1L, 1L, new Money(2031555000L))
        );
    }
}