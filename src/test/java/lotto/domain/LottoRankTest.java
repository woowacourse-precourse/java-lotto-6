package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoRankTest {
    @DisplayName("주어진 번호 일치 개수와 보너스 번호 일치 여부에 따라 LottoRank를 반환한다.")
    @ParameterizedTest
    @MethodSource("findArgumentsProvider")
    void find(int matchCount, boolean bonusNumberMatches, LottoRank expectedLottoRank) {
        assertThat(LottoRank.find(matchCount, bonusNumberMatches)).isEqualTo(expectedLottoRank);
    }

    static Stream<Arguments> findArgumentsProvider() {
        return Stream.of(
                Arguments.of(6, true, LottoRank.FIRST),
                Arguments.of(6, false, LottoRank.FIRST),
                Arguments.of(5, true, LottoRank.SECOND),
                Arguments.of(5, false, LottoRank.THIRD),
                Arguments.of(4, true, LottoRank.FOURTH),
                Arguments.of(4, false, LottoRank.FOURTH),
                Arguments.of(3, true, LottoRank.FIFTH),
                Arguments.of(3, false, LottoRank.FIFTH),
                Arguments.of(2, true, LottoRank.NONE),
                Arguments.of(2, false, LottoRank.NONE),
                Arguments.of(1, true, LottoRank.NONE),
                Arguments.of(1, false, LottoRank.NONE),
                Arguments.of(0, true, LottoRank.NONE),
                Arguments.of(0, false, LottoRank.NONE)
        );
    }

    @DisplayName("주어진 값을 LottoRank의 prize에 곱한 결과를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10})
    void multiplyPrize(int count) {
        assertThat(LottoRank.FIRST.multiplyPrize(count)).isEqualTo((long) LottoRank.FIRST.prize() * count);
    }
}
