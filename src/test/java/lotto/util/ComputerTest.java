package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerTest {
    private Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
    }

    @Test
    void 로또번호_정렬_테스트() {
        List<Integer> lottoNumber = new ArrayList<>(List.of(1, 6, 2, 5, 4, 3));
        assertThat(computer.sortNumber(lottoNumber))
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 로또_구매_횟수_구하는_테스트() {
        assertThat(computer.calculateLottoTicketCount(1000))
                .isEqualTo(1);
        assertThat(computer.calculateLottoTicketCount(5000))
                .isEqualTo(5);
        assertThat(computer.calculateLottoTicketCount(10000))
                .isEqualTo(10);
        assertThat(computer.calculateLottoTicketCount(100000))
                .isEqualTo(100);
    }

    @Test
    void 당첨번호와_랜덤번호가_일치하는_번호가_몇개인지_반환하는_테스트() {
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> lottoNumber1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> lottoNumber2 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 7));
        List<Integer> lottoNumber3 = new ArrayList<>(List.of(1, 2, 3, 4, 7, 8));
        List<Integer> lottoNumber4 = new ArrayList<>(List.of(1, 2, 3, 7, 8, 9));
        List<Integer> lottoNumber5 = new ArrayList<>(List.of(1, 2, 7, 8, 9, 10));
        assertThat(computer.getMatchCount(lottoNumber1, winningNumber))
                .isEqualTo(6);
        assertThat(computer.getMatchCount(lottoNumber2, winningNumber))
                .isEqualTo(5);
        assertThat(computer.getMatchCount(lottoNumber3, winningNumber))
                .isEqualTo(4);
        assertThat(computer.getMatchCount(lottoNumber4, winningNumber))
                .isEqualTo(3);
        assertThat(computer.getMatchCount(lottoNumber5, winningNumber))
                .isEqualTo(2);
    }

    @Test
    void 매치된_번호_개수에_따라_등수를_판별하는_테스트() {
        assertThat(computer.getWinningRank(3))
                .isEqualTo(5);
        assertThat(computer.getWinningRank(4))
                .isEqualTo(4);
        assertThat(computer.getWinningRank(6))
                .isEqualTo(1);
    }

    @Test
    void 매치된_번호_개수가_5개일때_보너스볼로_2등_판별하는_테스트() {
        List<Integer> lottoNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        assertThat(computer.getWinningSecondRank(lottoNumber, 1))
                .isEqualTo(2);
        assertThat(computer.getWinningSecondRank(lottoNumber, 4))
                .isEqualTo(2);
        assertThat(computer.getWinningSecondRank(lottoNumber, 7))
                .isEqualTo(3);
        assertThat(computer.getWinningSecondRank(lottoNumber, 45))
                .isEqualTo(3);
    }

    @Test
    void 등수별_당청_횟수를_가져오는_테스트() {
        HashMap<Integer, Integer> winningCount = new HashMap<>();
        winningCount.put(1, 0);
        winningCount.put(2, 1);
        winningCount.put(3, 4);
        winningCount.put(4, 20);
        winningCount.put(5, 60);
        assertThat(computer.getRankCount(1, winningCount))
                .isEqualTo(0);
        assertThat(computer.getRankCount(2, winningCount))
                .isEqualTo(1);
        assertThat(computer.getRankCount(3, winningCount))
                .isEqualTo(4);
        assertThat(computer.getRankCount(4, winningCount))
                .isEqualTo(20);
        assertThat(computer.getRankCount(5, winningCount))
                .isEqualTo(60);

    }

    @Test
    void 총_상금을_구하는_테스트() {
        HashMap<Integer, Integer> winningCount1 = new HashMap<>();
        HashMap<Integer, Integer> winningCount2 = new HashMap<>();
        winningCount1.put(3, 2);
        winningCount1.put(5, 1);
        winningCount2.put(1, 1);
        assertThat(computer.calculateTotalPrize(winningCount1))
                .isEqualTo(3005000);
        assertThat(computer.calculateTotalPrize(winningCount2))
                .isEqualTo(2000000000);
    }

    @Test
    void 총_상금_수익률을_계산하는_테스트() {
        int paymentAmount = 8000;
        int totalPrize1 = 3005000;
        int totalPrize2 = 5000;
        int totalPrize3 = 0;

        assertThat(computer.calculateTotalProfit(totalPrize1, paymentAmount))
                .isEqualTo("37562.5%");
        assertThat(computer.calculateTotalProfit(totalPrize2, paymentAmount))
                .isEqualTo("62.5%");
        assertThat(computer.calculateTotalProfit(totalPrize3, paymentAmount))
                .isEqualTo("0.0%");
    }
}