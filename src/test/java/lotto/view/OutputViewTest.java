package lotto.view;

import lotto.domain.IssueLottery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OutputViewTest {

    private OutputView outputView;
    private IssueLottery issueLottery;
    private List<List<Integer>> lotteryTickets;
    private int ticketCount;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        issueLottery = new IssueLottery();
    }
    @Test
    void 로또를_발행하고_출력하는_기능_테스트() {
        ticketCount = 7;
        lotteryTickets = issueLottery.issueTickets(ticketCount);
        outputView.printLotteryTickets(ticketCount, lotteryTickets);
    }
}
