package lotto.view;

import lotto.domain.IssueLottery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputViewTest {

    private OutputView outputView;
    private IssueLottery issueLottery;
    private List<List<Integer>> lotteryTickets;
    private int ticketCount;
    private Map<Integer, Integer> winningTicketsCount;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        issueLottery = new IssueLottery();
        winningTicketsCount = new HashMap<>();
    }

    @Test
    void 로또를_발행하고_출력하는_기능_테스트() {
        ticketCount = 7;
        lotteryTickets = issueLottery.issueTickets(ticketCount);
        outputView.printLotteryTickets(ticketCount, lotteryTickets);
    }

    @Test
    void 등수별_로또_당첨_티켓_개수를_출력하는_기능_테스트() {
        winningTicketsCount.put(1, 0);
        winningTicketsCount.put(2, 1);
        winningTicketsCount.put(3, 3);
        winningTicketsCount.put(4, 0);
        winningTicketsCount.put(5, 2);

        outputView.printWinningStatistics(winningTicketsCount);
    }
}
