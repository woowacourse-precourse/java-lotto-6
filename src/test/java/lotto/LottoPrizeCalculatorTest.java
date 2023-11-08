package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.Model.LottoPrizeCalculator;
import lotto.Model.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoPrizeCalculatorTest {
    private LottoPrizeCalculator calculator;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    private static final int PRIZE_FOR_3_MATCHES = 5000;
    private static final int PRIZE_FOR_4_MATCHES = 50000;
    private static final int PRIZE_FOR_5_MATCHES = 1500000;
    private static final int PRIZE_FOR_5_PLUS_BONUS_MATCHES = 30000000;
    private static final int PRIZE_FOR_6_MATCHES = 2000000000;

    @BeforeEach
    void 준비() {
        winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        bonusNumber = 7;
        calculator = new LottoPrizeCalculator(winningNumbers, bonusNumber);
    }

    @Test
    void 매치되는_번호가_하나도_없을_경우() {
        List<LottoTicket> purchasedTickets = Arrays.asList(
                new LottoTicket(Arrays.asList(8, 9, 10, 11, 12, 13))
        );
        calculator.calculateStatistics(purchasedTickets);
        assertPrizeCountMap(0, 0, 0, 0, 0);
    }

    @Test
    void 매치되는_번호가_하나일_경우() {
        List<LottoTicket> purchasedTickets = Arrays.asList(
                new LottoTicket(Arrays.asList(1, 9, 10, 11, 12, 13))
        );
        calculator.calculateStatistics(purchasedTickets);
        assertPrizeCountMap(0, 0, 0, 0, 0);
    }

    @Test
    void 매치되는_번호가_둘일_경우() {
        List<LottoTicket> purchasedTickets = Arrays.asList(
                new LottoTicket(Arrays.asList(1, 2, 10, 11, 12, 13))
        );
        calculator.calculateStatistics(purchasedTickets);
        assertPrizeCountMap(0, 0, 0, 0, 0);
    }

    @Test
    void 매치되는_번호가_셋일_경우() {
        List<LottoTicket> purchasedTickets = Arrays.asList(
                new LottoTicket(Arrays.asList(1, 2, 3, 11, 12, 13))
        );
        calculator.calculateStatistics(purchasedTickets);
        assertPrizeCountMap(1, 0, 0, 0, 0);
    }

    @Test
    void 매치되는_번호가_넷일_경우() {
        List<LottoTicket> purchasedTickets = Arrays.asList(
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 12, 13))
        );
        calculator.calculateStatistics(purchasedTickets);
        assertPrizeCountMap(0, 1, 0, 0, 0);
    }

    @Test
    void 매치되는_번호가_다섯일_경우() {
        List<LottoTicket> purchasedTickets = Arrays.asList(
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 13))
        );
        calculator.calculateStatistics(purchasedTickets);
        assertPrizeCountMap(0, 0, 1, 0, 0);
    }

    @Test
    void 매치되는_번호가_다섯_플러스_보너스일_경우() {
        List<LottoTicket> purchasedTickets = Arrays.asList(
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, bonusNumber))
        );
        calculator.calculateStatistics(purchasedTickets);
        assertPrizeCountMap(0, 0, 0, 1, 0);
    }

    @Test
    void 매치되는_번호가_여섯일_경우() {
        List<LottoTicket> purchasedTickets = Arrays.asList(
                new LottoTicket(winningNumbers)
        );
        calculator.calculateStatistics(purchasedTickets);
        assertPrizeCountMap(0, 0, 0, 0, 1);
    }

    private void assertPrizeCountMap(int expectedThree, int expectedFour, int expectedFive, int expectedFivePlusBonus, int expectedSix) {
        Map<Integer, Integer> prizeCountMap = calculator.getPrizeCountMap();
        assertEquals(expectedThree, prizeCountMap.getOrDefault(PRIZE_FOR_3_MATCHES, 0));
        assertEquals(expectedFour, prizeCountMap.getOrDefault(PRIZE_FOR_4_MATCHES, 0));
        assertEquals(expectedFive, prizeCountMap.getOrDefault(PRIZE_FOR_5_MATCHES, 0));
        assertEquals(expectedFivePlusBonus, prizeCountMap.getOrDefault(PRIZE_FOR_5_PLUS_BONUS_MATCHES, 0));
        assertEquals(expectedSix, prizeCountMap.getOrDefault(PRIZE_FOR_6_MATCHES, 0));
    }
}
