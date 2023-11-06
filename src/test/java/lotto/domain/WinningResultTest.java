package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningResultTest {
    static Stream<Arguments> provideMatchCount() {
        return Stream.of(
                Arguments.of(0, true, WinningResult.LOSING),
                Arguments.of(1, false, WinningResult.LOSING),
                Arguments.of(2, true, WinningResult.LOSING),
                Arguments.of(3, false, WinningResult.FIFTH),
                Arguments.of(3, true, WinningResult.FIFTH),
                Arguments.of(4, false, WinningResult.FOURTH),
                Arguments.of(4, true, WinningResult.FOURTH),
                Arguments.of(5, false, WinningResult.THIRD),
                Arguments.of(5, true, WinningResult.SECOND),
                Arguments.of(6, false, WinningResult.FIRST),
                Arguments.of(6, true, WinningResult.FIRST)
        );
    }
    @ParameterizedTest
    @MethodSource("provideMatchCount")
    void 당첨_결과를_구할_수_있다(int matchCount, boolean bonusMatch, WinningResult expected) {
        // when
        WinningResult actual = WinningResult.of(matchCount, bonusMatch);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
