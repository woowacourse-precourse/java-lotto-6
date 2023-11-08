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

    @BeforeEach
    public void setUp() {
        lottoTickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 45)),
                new Lotto(List.of(1, 2, 3, 4, 44, 45)),
                new Lotto(List.of(1, 2, 3, 7, 44, 45)),
                new Lotto(List.of(1, 2, 7, 8, 44, 45)),
                new Lotto(List.of(40, 41, 42, 43, 44, 45))
        );

        winningNumber = new WinningNumber(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
    }

    @DisplayName("당첨 내역을 산출할 수 있다.")
    @Test
    void createWinningResult() {
        Map<Rank, Integer> winningResult = Statistics.calculateWinningResult(
                lottoTickets, winningNumber);
        assertThat(winningResult.get(Rank.FIRST)).isEqualTo(1);
        assertThat(winningResult.get(Rank.SECOND)).isEqualTo(1);
        assertThat(winningResult.get(Rank.THIRD)).isEqualTo(1);
        assertThat(winningResult.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(winningResult.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(winningResult.get(Rank.MISS)).isEqualTo(2);
    }
}
