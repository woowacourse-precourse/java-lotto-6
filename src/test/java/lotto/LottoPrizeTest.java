package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoPrizeTest {

    @DisplayName("LottoPrize Enum 객체와 일치하는 설명 문자열을 반환한다.")
    @ParameterizedTest
    @MethodSource("provideLottoPrizesForTesting")
    void givenLottoPrize_whenGetPrizeDescription_thenCorrectDescription(
            LottoPrize lottoPrize,
            String expectedDescription) {
        // When
        String actualDescription = lottoPrize.getPrizeDescription();

        // Then
        assertThat(actualDescription).isEqualTo(expectedDescription);
    }

    static Stream<Arguments> provideLottoPrizesForTesting() {
        return Stream.of(
                Arguments.of(LottoPrize.NONE, "0개 일치 (0원)"),
                Arguments.of(LottoPrize.FIFTH, "3개 일치 (5,000원)"),
                Arguments.of(LottoPrize.FOURTH, "4개 일치 (50,000원)"),
                Arguments.of(LottoPrize.THIRD, "5개 일치 (1,500,000원)"),
                Arguments.of(LottoPrize.SECOND, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
                Arguments.of(LottoPrize.FIRST, "6개 일치 (2,000,000,000원)")
        );
    }
}
