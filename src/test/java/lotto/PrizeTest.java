package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PrizeTest {

    @DisplayName("일치하는 개수에 따라 등수 반환")
    @ParameterizedTest
    @MethodSource("parameterProvider")
    void matchPrize(long matchWinningNumber, long matchBonusNumber, String expected) {
        //given
        Prize prize;

        //when
        prize = Prize.matchPrize(matchWinningNumber, matchBonusNumber);

        //then
        assertThat(prize.name()).isEqualTo(expected);
    }

    private static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.arguments(6, 0, "FIRST"),
                Arguments.arguments(5, 1, "SECOND"),
                Arguments.arguments(5, 0, "THIRD"),
                Arguments.arguments(4, 0, "FOURTH"),
                Arguments.arguments(3, 1, "FIFTH")
        );
    }

    @Test
    void earningRateCalculator() {
    }

    @Test
    void countPrizeHistory() {
    }
}