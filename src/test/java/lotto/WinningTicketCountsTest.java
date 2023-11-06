package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningTicketCountsTest {

    private WinningTicketCounts winningTicketCounts;

    @BeforeEach
    void setUp() {
        winningTicketCounts = new WinningTicketCounts();
    }

    @DisplayName("1등의 count가 증가한다.")
    @Test
    void incrementCount() {
        //when
        winningTicketCounts.incrementCount(WinningRank.FIRST);
        //then
        assertThat(winningTicketCounts.getCount(WinningRank.FIRST)).isEqualTo(1);
    }

}