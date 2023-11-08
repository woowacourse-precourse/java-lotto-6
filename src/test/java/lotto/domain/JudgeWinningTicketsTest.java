package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JudgeWinningTicketsTest {
    private List<List<Integer>> lotteryTickets;
    private Map<Integer, Integer> winningTicketsCount;
    private JudgeWinningTickets judgeWinningTickets;
    private List<Integer> winningTicketNumbers;


    @BeforeEach
    void SetUp() {
        judgeWinningTickets = new JudgeWinningTickets();
        lotteryTickets = new ArrayList<>();
        winningTicketNumbers = new ArrayList<Integer>();
    }

    @Test
    void 등수가_1등_로또_테스트() {
        int ticketCount = 5;
        lotteryTickets.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        lotteryTickets.add(Arrays.asList(11, 12, 13, 14, 15, 16));
        lotteryTickets.add(Arrays.asList(22, 23, 24, 25, 26, 27));
        lotteryTickets.add(Arrays.asList(33, 34, 35, 36, 37, 38));
        lotteryTickets.add(Arrays.asList(39, 40, 41, 43, 44, 45));
        winningTicketNumbers = Arrays.asList(11, 12, 13, 14, 15, 16);
        int bonusNumber = 10;
        winningTicketsCount = judgeWinningTickets.countWinningTickets(ticketCount, lotteryTickets, winningTicketNumbers, bonusNumber);
        int result = winningTicketsCount.get(1);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 등수가_2등_로또_테스트() {
        int ticketCount = 5;
        lotteryTickets.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        lotteryTickets.add(Arrays.asList(11, 12, 13, 14, 15, 16));
        lotteryTickets.add(Arrays.asList(22, 23, 24, 25, 26, 27));
        lotteryTickets.add(Arrays.asList(33, 34, 35, 36, 37, 38));
        lotteryTickets.add(Arrays.asList(39, 40, 41, 43, 44, 45));
        winningTicketNumbers = Arrays.asList(10, 11, 12, 13, 14, 15);
        int bonusNumber = 10;
        winningTicketsCount = judgeWinningTickets.countWinningTickets(ticketCount, lotteryTickets, winningTicketNumbers, bonusNumber);
        int result = winningTicketsCount.get(2);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 등수가_3등_로또_테스트() {
        int ticketCount = 5;
        lotteryTickets.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        lotteryTickets.add(Arrays.asList(11, 12, 13, 14, 15, 16));
        lotteryTickets.add(Arrays.asList(22, 23, 24, 25, 26, 27));
        lotteryTickets.add(Arrays.asList(33, 34, 35, 36, 37, 38));
        lotteryTickets.add(Arrays.asList(39, 40, 41, 43, 44, 45));
        winningTicketNumbers = Arrays.asList(11, 12, 13, 14, 15, 26);
        int bonusNumber = 10;
        winningTicketsCount = judgeWinningTickets.countWinningTickets(ticketCount, lotteryTickets, winningTicketNumbers, bonusNumber);
        int result = winningTicketsCount.get(3);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 등수가_4등_로또_테스트() {
        int ticketCount = 5;
        lotteryTickets.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        lotteryTickets.add(Arrays.asList(11, 12, 13, 14, 15, 16));
        lotteryTickets.add(Arrays.asList(22, 23, 24, 25, 26, 27));
        lotteryTickets.add(Arrays.asList(33, 34, 35, 36, 37, 38));
        lotteryTickets.add(Arrays.asList(39, 40, 41, 43, 44, 45));
        winningTicketNumbers = Arrays.asList(11, 12, 13, 14, 20);
        int bonusNumber = 10;
        winningTicketsCount = judgeWinningTickets.countWinningTickets(ticketCount, lotteryTickets, winningTicketNumbers, bonusNumber);
        int result = winningTicketsCount.get(4);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 등수가_5등_로또_테스트() {
        int ticketCount = 5;
        lotteryTickets.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        lotteryTickets.add(Arrays.asList(11, 12, 13, 14, 15, 16));
        lotteryTickets.add(Arrays.asList(22, 23, 24, 25, 26, 27));
        lotteryTickets.add(Arrays.asList(33, 34, 35, 36, 37, 38));
        lotteryTickets.add(Arrays.asList(39, 40, 41, 43, 44, 45));
        winningTicketNumbers = Arrays.asList(11, 12, 13, 43, 44, 45);
        int bonusNumber = 10;
        winningTicketsCount = judgeWinningTickets.countWinningTickets(ticketCount, lotteryTickets, winningTicketNumbers, bonusNumber);
        int result = winningTicketsCount.get(5);
        assertThat(result).isEqualTo(2);
    }
}
