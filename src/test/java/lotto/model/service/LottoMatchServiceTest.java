package lotto.model.service;

import lotto.model.entity.Lotto;
import lotto.model.entity.Ranking;
import lotto.utils.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMatchServiceTest {
    private LottoMatchService service;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    @BeforeEach
    void setUp() {
        service = new LottoMatchService();
        winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        bonusNumber = 7;
    }

    @Test
    @DisplayName("로또 순위 결정 - 올바른 순위를 반환한다")
    void determineLottoRankings_ReturnsCorrectRankings() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // FIRST
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)), // THIRD
                new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11)), // FOURTH
                new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12)) // FIFTH
        );

        List<Ranking> results = service.determineLottoRankings(lottos, winningNumbers, bonusNumber);

        assertThat(results).containsExactly(Ranking.FIRST, Ranking.THIRD, Ranking.FOURTH, Ranking.FIFTH);
    }

    @Test
    @DisplayName("순위 요약 - 올바른 순위 요약을 반환한다")
    void summarizeRankings_ReturnsCorrectSummary() {
        List<Ranking> rankings = Arrays.asList(Ranking.FIRST, Ranking.FIRST, Ranking.THIRD, Ranking.FOURTH, Ranking.FIFTH, Ranking.NO_PRIZE);

        Map<Ranking, Long> summary = service.summarizeRankings(rankings);

        assertThat(summary).containsExactlyEntriesOf(
                new LinkedHashMap<>() {{
                    put(Ranking.FIRST, 2L);
                    put(Ranking.THIRD, 1L);
                    put(Ranking.FOURTH, 1L);
                    put(Ranking.FIFTH, 1L);
                    put(Ranking.NO_PRIZE, 1L);
                }}
        );
    }

    @Test
    @DisplayName("수익률 계산 - 올바른 수익률을 반환한다")
    void calculateRevenueRate_ReturnsCorrectRate() {
        int ticketPrice = 1000;
        int ticketCount = 5;
        List<Ranking> rankings = Arrays.asList(Ranking.FIRST, Ranking.NO_PRIZE, Ranking.NO_PRIZE, Ranking.NO_PRIZE, Ranking.NO_PRIZE);

        double revenueRate = service.calculateRevenueRate(ticketPrice, ticketCount, rankings);

        long totalWinnings = Ranking.FIRST.getPrize();
        double expectedRevenueRate = (double) totalWinnings / (ticketPrice * ticketCount) * Constants.PERCENT_MULTIPLIER;

        assertThat(revenueRate).isEqualTo(expectedRevenueRate);
    }
}
