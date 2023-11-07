package lotto;

import java.util.stream.Stream;
import lotto.domain.MatchResult;
import lotto.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    private static Stream<Arguments> provideEarnPrizeTestArg() {
        return Stream.of(
                Arguments.of(new MatchResult(6, false), Prize.FIRST),
                Arguments.of(new MatchResult(5, true), Prize.SECOND),
                Arguments.of(new MatchResult(5, false), Prize.THIRD),
                Arguments.of(new MatchResult(4, true), Prize.FOURTH),
                Arguments.of(new MatchResult(4, false), Prize.FOURTH),
                Arguments.of(new MatchResult(3, true), Prize.FIFTH),
                Arguments.of(new MatchResult(3, false), Prize.FIFTH),
                Arguments.of(new MatchResult(2, true), Prize.BLANK),
                Arguments.of(new MatchResult(2, false), Prize.BLANK)
        );
    }

    @DisplayName("올바른 상을 반환한다")
    @ParameterizedTest
    @MethodSource("provideEarnPrizeTestArg")
    void earnPrizeTest(MatchResult result, Prize deserve) {
        Prize earned = Prize.earnPrize(result);

        assertThat(earned).isEqualTo(deserve);
    }
}
