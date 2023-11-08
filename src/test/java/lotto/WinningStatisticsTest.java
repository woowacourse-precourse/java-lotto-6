package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningStatisticsTest {

    private final List<Integer> matchingNumber = new ArrayList<>(Collections.nCopies(7, 0));
    private WinningStatistics winningStatistics;

    @BeforeEach
    void setUp() {
        winningStatistics = new WinningStatistics();
        matchingNumber.set(0, 0);
        matchingNumber.set(3, 0);
        matchingNumber.set(4, 0);
        matchingNumber.set(5, 0);
        matchingNumber.set(6, 0);
    }

    @Test
    @DisplayName("티켓 수가 1,000원단위로 나뉘어 지는지 테스트")
    void canChangedLottoTicketsTest() {
        long ticket = winningStatistics.purchaseLottoTickets(5000);
        assertThat(ticket).isEqualTo(5);
        ticket = winningStatistics.purchaseLottoTickets(3000);
        assertThat(ticket).isEqualTo(3);
        ticket = winningStatistics.purchaseLottoTickets(12000);
        assertThat(ticket).isEqualTo(12);
    }


    @Test
    @DisplayName("당첨 개수에 따른 수익률 테스트")
    void matchingTotalTest() {
        long userCost = 20000;
        double actual = winningStatistics.matchingTotal(userCost, matchingNumber);
        double expected = matchingNumber.get(3) * 5_000 +
                matchingNumber.get(4) * 50_000 +
                matchingNumber.get(5) * 1_500_000 +
                matchingNumber.get(6) * 2_000_000_000 +
                matchingNumber.get(0) * 30_000_000;
        expected = expected / userCost * 100;

        assertEquals(expected, actual);
    }
}