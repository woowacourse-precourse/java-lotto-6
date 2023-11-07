package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {
    private List<Lotto> lottoTickets;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    @BeforeEach
    void setUp() {
        lottoTickets = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(6, 7, 8, 9, 10, 11)),
                new Lotto(Arrays.asList(1, 2, 6, 8, 10, 12)),
                new Lotto(Arrays.asList(20, 21, 22, 23, 24, 25))
        );
        winningNumbers = Arrays.asList(3, 4, 5, 6, 7, 8);
        bonusNumber = 45;
    }

    @DisplayName("각 로또가 몇 등에 당첨되었는지 개수를 센다.")
    @Test
    void countLottoRank() {
        Map<Rank, Long> winningCounts = Referee.countLottoRank(lottoTickets, winningNumbers, bonusNumber);

        assertEquals(1, winningCounts.get(Rank.FOURTH));
        assertEquals(1, winningCounts.get(Rank.FIFTH));
        assertEquals(2, winningCounts.get(Rank.FAIL));
    }

    @DisplayName("로또 당첨 결과에 대한 수익률을 계산한다.")
    @Test
    void getLottoProfit() {
        int purchaseAmount = 10000;

        Map<Rank, Long> winningCounts = Referee.countLottoRank(lottoTickets, winningNumbers, bonusNumber);
        double profitRate = Referee.getLottoProfit(winningCounts, purchaseAmount);

        assertEquals(550.0, profitRate);
    }
}