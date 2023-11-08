package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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