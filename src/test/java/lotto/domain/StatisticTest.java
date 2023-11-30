package lotto.domain;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticTest {
    private List<Lotto> lottoTickets;
    private WinningNumber winningNumber;
    private Map<Rank, Integer> winningResult;

    @BeforeEach
    public void setUp() {
        lottoTickets = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );

        winningNumber = new WinningNumber(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        winningResult = Statistics.calculateWinningResult(lottoTickets, winningNumber);
    }

    @DisplayName("당첨 내역을 산출할 수 있다.")
    @Test
    void createWinningResult() {
        assertThat(winningResult.get(Rank.FIRST)).isEqualTo(0);
        assertThat(winningResult.get(Rank.SECOND)).isEqualTo(0);
        assertThat(winningResult.get(Rank.THIRD)).isEqualTo(0);
        assertThat(winningResult.get(Rank.FOURTH)).isEqualTo(0);
        assertThat(winningResult.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(winningResult.get(Rank.MISS)).isEqualTo(7);
    }

    @DisplayName("수익률을 계산할 수 있다.")
    @Test
    void calculateRateOfReturn() {
        Statistics statistics = new Statistics(winningResult);
        double rateOfReturn = statistics.calculateRateOfReturn(new Money(8000));
        assertThat(rateOfReturn).isEqualTo(62.5);
    }
}
