package lotto.model;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class RankTest {

    @Test
    void 해당_Rank가_BOOM이_아니면_당첨을_반환한다() {
        // when
        boolean result = Rank.FIFTH.isWinningRank();

        // then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void 해당_Rank가_BOOM이면_낙첨을_반환한다() {
        // when
        boolean result = Rank.BOOM.isWinningRank();

        // then
        Assertions.assertThat(result).isFalse();
    }

    @MethodSource("provideParametersForMakeRank")
    @ParameterizedTest()
    void 매칭_카운트와_보너스넘버_일치_결과를_가지고_당첨을_만든다(int matchingCount, boolean hasBonusNumber, Rank expected) {
        // when
        Rank result = Rank.of(matchingCount, hasBonusNumber);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> provideParametersForMakeRank() {
        return Stream.of(Arguments.of(1, false, Rank.BOOM),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(4, true, Rank.FOURTH),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(6, true, Rank.FIRST)
        );
    }
}
