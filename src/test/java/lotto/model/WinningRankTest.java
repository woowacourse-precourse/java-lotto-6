package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WinningRankTest {

    @ParameterizedTest
    @CsvSource(value = {"6:true:FIRST", "5:true:SECOND", "5:false:THIRD", "4:false:FOURTH",
            "3:true:FIFTH"}, delimiter = ':')
    void 랭크_판별_검증(int matchCount, boolean hasBonus, WinningRank rank) {
        Assertions.assertThat(WinningRank.getWinningRank(matchCount, hasBonus)).isEqualTo(rank);
    }
}
