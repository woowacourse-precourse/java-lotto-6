package lotto.domain.result;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningRankTest {



    @ParameterizedTest
    @DisplayName("적절한 WinningRank를 찾는 기능")
    @MethodSource("argumentsFindWinningRank")
    void WinningRank_find(int matchCount, boolean hasBonusNumber, WinningRank winningRank) {
        //when
        WinningRank findWinningRank = WinningRank.findWinningRank(matchCount, hasBonusNumber);

        //then
        Assertions.assertThat(findWinningRank).isEqualTo(winningRank);
    }
    private static Stream<Arguments> argumentsFindWinningRank() {
        return Stream.of(
                Arguments.of(6, false, WinningRank.FIRST),
                Arguments.of(5, true, WinningRank.SECOND),
                Arguments.of(5, false, WinningRank.THIRD),
                Arguments.of(4, false, WinningRank.FOURTH),
                Arguments.of(3, false, WinningRank.FIFTH),
                Arguments.of(2, false, WinningRank.EMPTY)
        );
    }
}