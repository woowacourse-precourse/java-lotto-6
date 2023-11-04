package lotto.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningPrizeTest {
    @DisplayName("맞춘 개수에 맞는 WinningPrize를 반환하는지 확인")
    @ParameterizedTest
    @MethodSource("winningPrizeWithMatch")
    void checkPrizeWithMatch(int match, WinningPrize answer) {
        WinningPrize prize = WinningPrize.getPrizeWithMatch(match);
        assertThat(prize).isEqualTo(answer);
    }

    static Stream<Arguments> winningPrizeWithMatch() {
        return Stream.of(
                Arguments.of(6, WinningPrize.FIRST_PLACE),
                Arguments.of(5, WinningPrize.THIRD_PLACE),
                Arguments.of(4, WinningPrize.FOURTH_PLACE),
                Arguments.of(3, WinningPrize.FIFTH_PLACE),
                Arguments.of(2, null)
        );
    }
}
