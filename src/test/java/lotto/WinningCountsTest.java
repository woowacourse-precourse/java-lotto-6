package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningCountsTest {

    private WinningCounts winningCounts;

    @BeforeEach
    void setUp() {
        winningCounts = new WinningCounts();
    }

    @DisplayName("1등의 count가 증가한다.")
    @Test
    void incrementCount() {
        //when
        winningCounts.incrementCount(WinningRank.FIRST);
        //then
        assertThat(winningCounts.getCount(WinningRank.FIRST)).isEqualTo(1);
    }

}