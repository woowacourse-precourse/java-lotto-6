package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankTest {

    static Stream<Arguments> provideRankData() {
        return Stream.of(
                Arguments.of(3, false, LottoRank.FIFTH),
                Arguments.of(4, false, LottoRank.FOURTH),
                Arguments.of(5, false, LottoRank.THIRD),
                Arguments.of(5, true, LottoRank.SECOND),
                Arguments.of(6, false, LottoRank.FIRST),
                Arguments.of(6, true, LottoRank.FIRST), // 보너스 번호 일치 여부에 관계없이 FIRST
                Arguments.of(2, false, LottoRank.NONE),
                Arguments.of(2, true, LottoRank.NONE),  // 매치된 번호가 2개 이하면 NONE
                Arguments.of(0, false, LottoRank.NONE)
        );
    }

    @DisplayName("LottoRank 결정 로직은 주어진 매치 수와 보너스 매치 여부에 기반하여 적절한 랭크를 반환해야 한다")
    @ParameterizedTest
    @MethodSource("provideRankData")
    void testDetermineRank(int matchCount, boolean matchBonus, LottoRank expected) {
        LottoRank actual = LottoRank.determineRank(matchCount, matchBonus);
        assertEquals(expected, actual);
    }
}
