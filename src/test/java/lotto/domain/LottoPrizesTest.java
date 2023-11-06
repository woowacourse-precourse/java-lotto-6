package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoPrizesTest {

    @DisplayName("당첨금을 컴마로 구분하고, '원'을 붙여 정확히 리턴하는지 확인합니다.")
    @ParameterizedTest(name = "{0}")
    @MethodSource("argumentsProvider")
    void winningAmountToString(
            String testMessage,
            LottoPrizes lottoPrizes,
            String expectedOutput) {
        assertThat(lottoPrizes.winningAmountToString()).isEqualTo(expectedOutput);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments("5등인 경우", LottoPrizes.THREE_NUMBERS_MATCHED, "5,000원"),
                arguments("4등인 경우", LottoPrizes.FOUR_NUMBERS_MATCHED, "50,000원"),
                arguments("3등인 경우", LottoPrizes.FIVE_NUMBER_MATCHED, "1,500,000원"),
                arguments("2등인 경우", LottoPrizes.FIVE_NUMBER_AND_BONUS_MATCHED, "30,000,000원"),
                arguments("1등인 경우", LottoPrizes.SIX_NUMBER_MATCHED, "2,000,000,000원")
        );
    }
}