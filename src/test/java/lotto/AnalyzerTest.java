package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class AnalyzerTest {
    private Analyzer analyzer;

    @BeforeEach
    void setUp() {
        analyzer = new Analyzer();
    }

    @DisplayName("로또 당첨 등수를 확인한다")
    @Test
    void checkWinningRank() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> ticketNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        int rank = analyzer.check(winningNumbers, ticketNumbers, bonusNumber);

        assertThat(rank).isEqualTo(1);
    }

    @DisplayName("수익률을 계산한다")
    @Test
    void calculateYield() {
        int purchaseAmount = 10000;
        Map<Integer, Integer> ticketResults = new HashMap<>();
        ticketResults.put(1, 0);
        ticketResults.put(2, 0);
        ticketResults.put(3, 0);
        ticketResults.put(4, 0);
        ticketResults.put(5, 4);

        double yieldRate = analyzer.calculateYield(purchaseAmount, ticketResults);

        assertThat(yieldRate).isEqualTo(200.0);
    }
}