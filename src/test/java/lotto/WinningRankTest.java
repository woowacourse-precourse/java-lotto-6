package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningRankTest {

    @DisplayName("당첨번호, 보너스번호와 일치하는 지에 따라 당첨등수를 결정한다.")
    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, true, FIFTH",
            "0, true, NO_WIN"
    })
    void crateWinningRankFromCountOfMatchingNumbersAndIsBonusMatchedint(int countOfMatchingNumbers, boolean isBonusMatched, WinningRank expectedRank) {
        WinningRank winningRank = WinningRank.from(countOfMatchingNumbers, isBonusMatched);

        assertThat(winningRank).isEqualTo(expectedRank);
    }
}