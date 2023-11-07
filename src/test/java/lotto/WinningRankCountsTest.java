package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningRankCountsTest {

    private WinningRankCounts winningRankCounts;

    @BeforeEach
    void setUp() {
        winningRankCounts = new WinningRankCounts();
    }

    @DisplayName("1등의 count가 증가한다.")
    @Test
    void incrementCount() {
        //when
        winningRankCounts.incrementCount(WinningRank.FIRST);
        //then
        assertThat(winningRankCounts.getCount(WinningRank.FIRST)).isEqualTo(1);
    }

}