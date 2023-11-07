package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.result.WinningRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningRankTest {
    @DisplayName("일치 수와 보너스가 주어졌을때 Enum 일치 테스트")
    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH",
            "1, false, NONE"
    })
    public void testGetRank(int match, boolean hasBonusNumber, WinningRank expectedRank) {
        WinningRank rank = WinningRank.getRank(match, hasBonusNumber);
        assertThat(rank).isEqualTo(expectedRank);
    }

    @DisplayName("등수와 금액 출력 테스트")
    @ParameterizedTest
    @CsvSource({
            "2_000_000_000, FIRST",
            "30_000_000, SECOND",
            "50_000, FOURTH",
            "0, NONE"
    })
    public void testGetPrize(int winningPrize, WinningRank expectedRank) {
        assertThat(winningPrize).isEqualTo(expectedRank.getPrize());
    }
}