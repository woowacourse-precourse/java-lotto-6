package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankTest {

    @ParameterizedTest
    @MethodSource("lottoRankProvider")
    @DisplayName("당첨 내역의 winning count가 증가하는지 테스트")
    void increaseWinningCountByMatchingCount(int matchingCount, boolean isMatchBonus, LottoRank lottoRank) {
        // given
        MatchResult matchResult = new MatchResult(matchingCount, isMatchBonus);

        // when
        int preCount = lottoRank.getWinningCount();

        // then
        LottoRank.increaseWinningCountByMatchingCount(matchResult);
        assertThat(lottoRank.getWinningCount()).isEqualTo(preCount + 1);
    }

    private static Stream<Arguments> lottoRankProvider() {
        return Stream.of(
                Arguments.of(6, false, LottoRank.FIRST),
                Arguments.of(5, true, LottoRank.SECOND),
                Arguments.of(5, false, LottoRank.THIRD),
                Arguments.of(4, false, LottoRank.FOURTH),
                Arguments.of(3, false, LottoRank.FIFTH)
        );
    }
}
