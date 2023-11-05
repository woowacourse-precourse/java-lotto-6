package lotto.domain;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    @ParameterizedTest
    @MethodSource("validRankParameters")
    void 맞힌_번호의_갯수와_보너스_번호_매칭_여부를_제공하면_랭크를_리턴한다(int matchCount, boolean isBonusNumberMatched, Rank expectedValue) {
        Rank actualValue = Rank.judgeBy(matchCount, isBonusNumberMatched);
        Assertions.assertEquals(actualValue, expectedValue);
    }


    static Stream<Arguments> validRankParameters() {
        return Stream.of(
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(6, false, Rank.FIRST)
        );
    }
}
