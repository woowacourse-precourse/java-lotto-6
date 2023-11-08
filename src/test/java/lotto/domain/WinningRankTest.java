package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.domain.WinningRank.FIFTH;
import static lotto.domain.WinningRank.FIRST;
import static lotto.domain.WinningRank.FOURTH;
import static lotto.domain.WinningRank.NONE;
import static lotto.domain.WinningRank.SECOND;
import static lotto.domain.WinningRank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

class WinningRankTest {
    @ParameterizedTest
    @MethodSource("winningCase")
    @DisplayName("로또 번호 당첨 개수 + 보너스 볼 일치 여부에 따른 WinningRank를 배정받는다")
    void getWinningRank(final int matchCount, final boolean hasBonus, final WinningRank expect) {
        assertThat(WinningRank.of(matchCount, hasBonus)).isEqualTo(expect);
    }

    private static Stream<Arguments> winningCase() {
        return Stream.of(
                Arguments.of(6, false, FIRST),
                Arguments.of(5, true, SECOND),
                Arguments.of(5, false, THIRD),
                Arguments.of(4, true, FOURTH),
                Arguments.of(4, false, FOURTH),
                Arguments.of(3, true, FIFTH),
                Arguments.of(3, false, FIFTH),
                Arguments.of(2, true, NONE),
                Arguments.of(2, false, NONE),
                Arguments.of(1, true, NONE),
                Arguments.of(1, false, NONE),
                Arguments.of(0, false, NONE)
        );
    }
}
