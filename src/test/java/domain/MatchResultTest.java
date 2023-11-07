package domain;

import lotto.domain.LottoRank;
import lotto.domain.dto.MatchResult;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.DisplayName;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

public class MatchResultTest {

    @ParameterizedTest
    @MethodSource("provideMatchResultData")
    @DisplayName("올바른 결과를 가지고 오는지 검증")
    void testGetRank(int matchCount, boolean matchBonus, Optional<LottoRank> expectedRank) {
        MatchResult result = new MatchResult(matchCount, matchBonus);

        assertThat(result.getRank()).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> provideMatchResultData() {
        return Stream.of(
                Arguments.of(6, false, Optional.of(LottoRank.FIRST)),
                Arguments.of(5, true, Optional.of(LottoRank.SECOND)),
                Arguments.of(5, false, Optional.of(LottoRank.THIRD)),
                Arguments.of(4, false, Optional.of(LottoRank.FOURTH)),
                Arguments.of(3, false, Optional.of(LottoRank.FIFTH)),
                Arguments.of(2, false, Optional.empty()),
                Arguments.of(1, true, Optional.empty())
        );
    }
}